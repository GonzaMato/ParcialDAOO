package org.errors.decorators

import org.errors.Message
import org.errors.Notification

class EncryptNotification(notification: Notification) : NotificationDecorator(notification) {
    override fun sendNotification(message: String): Message {
        return super.sendNotification("ENCRIPTADO $message")
    }
}