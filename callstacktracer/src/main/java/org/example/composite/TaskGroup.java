package org.example.composite;

import org.example.CallStackTracer;
import java.util.ArrayList;
import java.util.List;

public class TaskGroup implements TaskNode {

    private final String name;
    private final List<TaskNode> children = new ArrayList<>();

    public TaskGroup(String name) { this.name = name; }
    public void add(TaskNode child) { children.add(child); }

    @Override
    public void execute() {
        boolean anyFailure = false;

        try (CallStackTracer t = CallStackTracer.start("Group " + name)) {
            for (TaskNode n : children) {
                try {
                    n.execute();
                } catch (RuntimeException ex) {
                    anyFailure = true;                     // se registró fallo
                    System.err.println("   ↳ capturada excepción en hijo: " + ex.getMessage());
                }
            }
            if (!anyFailure) {                             // solo si todo OK
                t.complete();                              // el tracer permanece silencioso
            }
        }
    }
}
