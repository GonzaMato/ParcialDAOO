package org.example;

import org.example.exceptions.DatabaseException;
import org.example.exceptions.NetworkException;
import org.example.exceptions.TimeoutException;

public class DataService {

    private final ErrorSimulator sim;

    public DataService(ErrorSimulator sim) { this.sim = sim; }

    public String fetch() throws NetworkException, TimeoutException, DatabaseException {
        sim.maybeFail();
        return "REAL_DATA";
    }
}