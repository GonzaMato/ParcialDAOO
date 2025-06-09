package org.example;

import org.example.exceptions.DatabaseException;
import org.example.exceptions.NetworkException;
import org.example.exceptions.TimeoutException;

import java.util.concurrent.ThreadLocalRandom;

public class ErrorSimulator {
    private final int failRate;

    public ErrorSimulator(int failRate) {
        this.failRate = failRate;
    }

    public void maybeFail() throws NetworkException, TimeoutException, DatabaseException {
        int rand = ThreadLocalRandom.current().nextInt(100);
        if (rand >= failRate) return;

        switch (rand % 3) {
            case 0 -> throw new NetworkException("Simulated network glitch");
            case 1 -> throw new DatabaseException("Simulated DB corruption");
            case 2 -> throw new TimeoutException("Simulated timeout");
        }
    }
}
