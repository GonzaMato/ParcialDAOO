import org.errors.BaseNotification
import org.errors.decorators.DataCompressionNotification
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DataCompressionNotificationTest {

    @Test
    fun testDataCompressionNotification() {
        val dataCompressionNotification = DataCompressionNotification(BaseNotification())

        val message = dataCompressionNotification.sendNotification("Mensaje")

        assertEquals("COMPRIMIDO Mensaje", message.getBody())
    }
}