package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public final class CallStackTracer implements AutoCloseable {
    private final String label;
    private final Instant start = Instant.now();
    private final StackTraceElement[] snapshot = Thread.currentThread().getStackTrace();
    private boolean ok = false;

    private CallStackTracer(String label) { this.label = label; }
    public static CallStackTracer start(String label) { return new CallStackTracer(label); }
    public void complete() { ok = true; }

    @Override public void close() {
        if (ok) return; // solo habla en fallo
        long ms = Duration.between(start, Instant.now()).toMillis();
        System.err.println("❌ [" + label + "] failed after " + ms + " ms");
        Arrays.stream(snapshot).skip(3).limit(8).forEach(e -> System.err.println("   at " + e));
    }
}