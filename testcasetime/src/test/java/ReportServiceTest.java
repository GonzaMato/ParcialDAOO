import org.example.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class ReportServiceTest {
    @Test
    void renderReport_mustFinishUnder500ms() {
        ReportService svc = new ReportService();

        Assertions.assertTimeout(
                Duration.ofMillis(500),
                svc::renderReport
        );
    }

    @Test
    void renderReport_manualTiming() {
        ReportService svc = new ReportService();

        long start = System.nanoTime();
        String result = svc.renderReport();
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;

        Assertions.assertTrue(
                elapsedMs < 500,
                "Render tardó " + elapsedMs + " ms (límite 500 ms)"
        );
        Assertions.assertEquals("REPORT_OK", result);
    }
}
