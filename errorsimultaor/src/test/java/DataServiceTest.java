import org.example.DataService;
import org.example.ErrorSimulator;
import org.example.exceptions.DatabaseException;
import org.example.exceptions.NetworkException;
import org.example.exceptions.TimeoutException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataServiceTest {

    @Test
    public void fetch_mixedSuccessAndFailures() {
        ErrorSimulator sim = new ErrorSimulator(50);    // 50 % de error
        DataService svc   = new DataService(sim);

        boolean sawNetwork = false, sawDb = false, sawTimeout = false, sawSuccess = false;

        for (int i = 0; i < 200; i++) {
            try {
                String data = svc.fetch();
                assertEquals("REAL_DATA", data);
                sawSuccess = true;
            } catch (NetworkException e)  { sawNetwork  = true; }
            catch (TimeoutException e) { sawTimeout  = true; }
            catch (DatabaseException e){ sawDb       = true; }

            if (sawNetwork && sawDb && sawTimeout && sawSuccess) break;
        }

        assertTrue(sawSuccess, "Esperábamos al menos un éxito");
        assertTrue(sawNetwork, "Esperábamos al menos un NetworkException");
        assertTrue(sawTimeout, "Esperábamos al menos un TimeoutException");
        assertTrue(sawDb, "Esperábamos al menos un DatabaseException");
    }
}