package org.example.composite;

import org.example.CallStackTracer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

public class Leaf implements TaskNode {

    private final String name;
    private final int failRate;

    public Leaf(String name, int failRate) {
        this.name     = name;
        this.failRate = failRate;
    }

    @Override
    public void execute() {
        try (CallStackTracer t = CallStackTracer.start("Leaf " + name)) {

            maybeFail();
            System.out.println("Leaf " + name + " OK");

            t.complete();
        }
    }

    /** Inyecta uno de tres errores con la probabilidad configurada */
    private void maybeFail() {
        int r = ThreadLocalRandom.current().nextInt(100);
        if (r >= failRate) return;     // no falla
        throw new RuntimeException("RuntimeError in " + name);
    }
}