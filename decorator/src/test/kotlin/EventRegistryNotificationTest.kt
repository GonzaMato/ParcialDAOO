import org.errors.BaseNotification
import org.errors.decorators.EventRegistryNotification
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EventRegistryNotificationTest {

    @Test
    fun TestEventRegistryNotification() {
        val eventRegistryNotification = EventRegistryNotification(BaseNotification())

        val message = eventRegistryNotification.sendNotification("Mensaje")

        assertEquals("EVENTO REGISTRADO Mensaje", message.getBody())
    }
}