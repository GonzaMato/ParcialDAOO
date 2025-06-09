import org.errors.BaseNotification
import org.errors.Notification
import org.errors.decorators.EncryptNotification
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