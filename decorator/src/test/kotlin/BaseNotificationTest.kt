import org.errors.BaseNotification
import org.errors.Notification
import kotlin.test.Test
import kotlin.test.assertEquals

class BaseNotificationTest {


    @Test
    fun testNotificationBase(){
        val notification : Notification = BaseNotification()

        val message = notification.sendNotification("Mensaje")
        assertEquals("Mensaje" , message.getBody() )
    }
}