import org.example.MemoryLogger
import org.example.eventHandler.DeliveryProblemHandler
import org.example.events.DeliveryProblem
import org.example.events.NewOrder
import org.example.models.PayMethod
import org.example.models.Product
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DeliveryProblemHandlerTest {

    @Test
    fun testDeliveryProblem() {
        val event = DeliveryProblem(
            deliveryID = 2L,
            errorCode = "error",
            description = "description",
            location = "location"
        )



        val deliveryProblemHandler = DeliveryProblemHandler

        val memoryLogger = MemoryLogger()
        deliveryProblemHandler.logger = memoryLogger

        val result = deliveryProblemHandler.process(event)

        assertTrue { result }
        assertEquals(
            "Delivery Problem event: Delivery ID: 2 - Error Code: error",
            memoryLogger.getLog()
        )
    }

    @Test
    fun testNotDeliveryProblem() {
        val event = NewOrder(
            1L,
            listOf(Product(2.0, "Product")),
            "address",
            PayMethod.CASH
        )

        val deliveryProblemHandler = DeliveryProblemHandler

        val result = deliveryProblemHandler.process(event)

        assertFalse { result }
    }
}
