import org.example.BaseNotification
import org.example.Notification
import org.example.decorators.EncryptNotification
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EncryptNotification {


    @Test
    fun testEncryptNotification() {
        val encryptNotification : Notification = EncryptNotification(BaseNotification())

        val message = encryptNotification.sendNotification("Mensaje")

        assertEquals("ENCRIPTADO Mensaje", message.getBody())
    }
}