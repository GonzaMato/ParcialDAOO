import org.errors.BaseNotification
import org.errors.decorators.DataCompressionNotification
import org.errors.decorators.EncryptNotification
import org.errors.decorators.EventRegistryNotification
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

