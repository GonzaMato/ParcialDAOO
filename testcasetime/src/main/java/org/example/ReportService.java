package org.example;

public class ReportService {
    public String renderReport() {
        try {
            Thread.sleep(350);
        } catch (InterruptedException ign) {
            Thread.currentThread().interrupt();
        }
        return "REPORT_OK";
    }
}

