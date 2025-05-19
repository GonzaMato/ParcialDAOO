import org.example.BaseNotification
import org.example.decorators.DataCompressionNotification
import org.example.decorators.EncryptNotification
import org.example.decorators.EventRegistryNotification
import kotlin.test.Test
import kotlin.test.assertEquals

class DecoratorTest {


    @Test
    fun testCompressionEncryption(){
        val notification = BaseNotification()
        val dataCompressionNotification = DataCompressionNotification(notification)
        val encryptNotification = EncryptNotification(dataCompressionNotification)

        val message = encryptNotification.sendNotification("Hello World")

        assertEquals("COMPRIMIDO ENCRIPTADO Hello World", message.getBody())
    }

    @Test
    fun testCompressionEncryptionRegistry(){
        val notification = BaseNotification()
        val dataCompressionNotification = DataCompressionNotification(notification)
        val encryptNotification = EncryptNotification(dataCompressionNotification)
        val registryNotification = EventRegistryNotification(encryptNotification)

        val message = registryNotification.sendNotification("Hello World")

        assertEquals("COMPRIMIDO ENCRIPTADO EVENTO REGISTRADO Hello World", message.getBody())
    }
}

