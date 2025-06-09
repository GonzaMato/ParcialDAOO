package org.errors.decorators

import org.errors.Message
import org.errors.Notification

class DataCompressionNotification(notification: Notification) : NotificationDecorator(notification) {

    override fun sendNotification(message: String): Message {
        return super.sendNotification("COMPRIMIDO $message")
    }
}