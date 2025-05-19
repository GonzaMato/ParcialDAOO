package org.example.decorators

import org.example.Message
import org.example.Notification

class EncryptNotification(notification: Notification) : NotificationDecorator(notification) {
    override fun sendNotification(message: String): Message {
        return super.sendNotification("ENCRIPTADO $message")
    }
}