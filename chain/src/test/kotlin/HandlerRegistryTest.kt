import org.errors.eventHandler.HandlerRegistry
import org.errors.events.DeliveryProblem
import org.errors.events.NewOrder
import org.errors.events.Payment
import org.errors.models.PayMethod
import org.errors.models.Product
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*
import kotlin.test.assertTrue

class HandlerRegistryTest {


    @Test
    fun testHandlerRegistryPayment(){
        val handler = HandlerRegistry

        val payment =  Payment(
            1L,
            2.0,
            PayMethod.CASH,
            Date()
        )

        val originalOut = System.out

        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos, true, Charsets.UTF_8))

        handler.handleEvent(payment)

        System.out.flush()
        System.setOut(originalOut)
        val stdout = baos.toString(Charsets.UTF_8)

        assertTrue(
            "Received Payment event: Order ID = 1 - Amount = 2.0 - Payment Method = CASH" in stdout
        )
    }

    @Test
    fun testHandleRegistryNewProduct() {
        val handler = HandlerRegistry

        val NewOrder =  NewOrder(
            1L,
            listOf(Product(2.0, "Product")),
            "address",
            PayMethod.CASH
        )

        val originalOut = System.out

        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos, true, Charsets.UTF_8))

        handler.handleEvent(NewOrder)

        System.out.flush()
        System.setOut(originalOut)
        val stdout = baos.toString(Charsets.UTF_8)

        assertTrue(
            "New Product event: Client id = 1" in stdout
        )
    }

    @Test
    fun testHandleDeliveryProblem(){
        val handler = HandlerRegistry

        val DeliveryProblem =  DeliveryProblem(
            deliveryID = 2L,
            errorCode = "error",
            description = "description",
            location = "location"
        )

        val originalOut = System.out

        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos, true, Charsets.UTF_8))

        handler.handleEvent(DeliveryProblem)

        System.out.flush()
        System.setOut(originalOut)
        val stdout = baos.toString(Charsets.UTF_8)

        assertTrue(
            "Delivery Problem event: Delivery ID: 2 - Error Code: error" in stdout
        )
    }

}