
import org.example.composite.Leaf;
import org.example.composite.TaskGroup;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CallStackTracerTest {

    private static PrintStream originalErr;
    private ByteArrayOutputStream errCapture;

    /* ───────── redirigimos stderr antes / después de cada caso ───────── */

    @BeforeAll
    static void rememberStdErr() { originalErr = System.err; }

    @BeforeEach
    void setUp() {
        errCapture = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errCapture));
    }

    @AfterEach
    void tearDown() { System.setErr(originalErr); }

    /* ─────────────────────────── casos de prueba ─────────────────────── */

    @Test
    void leafSuccess_producesNoTrace() {
        Leaf ok = new Leaf("steady", 0);            // nunca falla

        ok.execute();

        assertEquals(
                "",
                errCapture.toString().trim(),
                "No debería imprimirse traza cuando la hoja tiene éxito"
        );
    }

    @Test
    void leafFailure_printsCleanTrace() {
        Leaf bad = new Leaf("always-bad", 100);     // siempre falla

        assertThrows(RuntimeException.class, bad::execute);

        String out = errCapture.toString();
        assertTrue(
                out.contains("❌ [Leaf always-bad]"),
                "El tracer debe imprimir encabezado con la etiqueta"
        );
        assertTrue(
                out.contains("at org.example.composite.Leaf.execute"),
                "La traza debe incluir el método execute() de Leaf"
        );
    }

    @Test
    void composite_mixedChildren_behavesAsExpected() {
        TaskGroup root = new TaskGroup("root");
        root.add(new Leaf("ok", 0));       // éxito
        root.add(new Leaf("bad", 100));    // falla
        root.add(new Leaf("ok2", 0));      // éxito

        // El grupo atrapa la RuntimeException de “bad” y sigue.
        root.execute();

        String out = errCapture.toString();

        // Traza de la hoja fallida…
        assertTrue(out.contains("❌ [Leaf bad]"));

        // …y también la del grupo, porque no se llamó complete()
        assertTrue(out.contains("❌ [Group root]"));

        // Verificamos que las hojas exitosas no generan traza
        assertFalse(out.contains("Leaf ok OK"));
        assertFalse(out.contains("Leaf ok2 OK"));
    }
}
