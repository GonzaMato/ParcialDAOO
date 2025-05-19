import org.example.MemoryLogger
import org.example.eventHandler.NewProductHandler
import org.example.events.DeliveryProblem
import org.example.events.NewOrder
import org.example.models.PayMethod
import org.example.models.Product
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NewProductHandlerTest {

    @Test
    fun testNewOrder() {
        val event = NewOrder(
            1L,
            listOf(Product(2.0, "Product")),
            "address",
            PayMethod.CASH
        )

        val newProductHandler = NewProductHandler

        val memoryLogger = MemoryLogger()
        newProductHandler.logger = memoryLogger

        val result = newProductHandler.process(event)

        assertTrue { result }
        assertEquals(
            "New Product event: Client id = 1",
            memoryLogger.getLog()
        )
    }

    @Test
    fun testNotNewProduct() {
        val event = DeliveryProblem(
            deliveryID = 2L,
            errorCode = "error",
            description = "description",
            location = "location"
        )

        val newProductHandler = NewProductHandler

        val result = newProductHandler.process(event)

        assertFalse { result }
    }
}