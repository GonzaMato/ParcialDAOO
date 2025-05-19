import org.example.MemoryLogger
import org.example.eventHandler.ReceivedPayHandler
import org.example.events.NewOrder
import org.example.events.Payment
import org.example.models.PayMethod
import org.example.models.Product
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RecievedPayHandlerTest {

    @Test
    fun testRecievedPayHandler() {
        val recievedPayHandler = ReceivedPayHandler
        val memoryLogger = MemoryLogger()
        recievedPayHandler.logger = memoryLogger

        val event = Payment(
            1L,
            2.0,
            PayMethod.CASH,
            Date()
        )

        val result = recievedPayHandler.process(event)

        assertTrue { result }
        assertEquals(
            "Received Payment event: Order ID = 1 - Amount = 2.0 - Payment Method = CASH",
            memoryLogger.getLog()
        )
    }

    @Test
    fun testNotRecievedPayHandler() {
        val recievedPayHandler = ReceivedPayHandler

        val event = NewOrder(
            1L,
            listOf(Product(2.0, "Product")),
            "address",
            PayMethod.CASH
        )

        val result = recievedPayHandler.process(event)

        assertFalse { result }
    }
}