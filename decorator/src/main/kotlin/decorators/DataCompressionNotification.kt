package org.example.decorators

import org.example.Message
import org.example.Notification

class DataCompressionNotification(notification: Notification) : NotificationDecorator(notification) {

    override fun sendNotification(message: String): Message {
        return super.sendNotification("COMPRIMIDO $message")
    }
}