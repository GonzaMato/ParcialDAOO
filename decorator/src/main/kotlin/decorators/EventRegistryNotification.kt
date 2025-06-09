package org.errors.decorators

import org.errors.Message
import org.errors.Notification

class EventRegistryNotification(notification: Notification) : NotificationDecorator(notification) {

    override fun sendNotification(message: String): Message {
        println("EVENTO REGISTRADO $message")
        return super.sendNotification("EVENTO REGISTRADO $message")
    }
}