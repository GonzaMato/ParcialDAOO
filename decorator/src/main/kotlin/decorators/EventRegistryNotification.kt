package org.example.decorators

import org.example.Message
import org.example.Notification

class EventRegistryNotification(notification: Notification) : NotificationDecorator(notification) {

    override fun sendNotification(message: String): Message {
        println("EVENTO REGISTRADO $message")
        return super.sendNotification("EVENTO REGISTRADO $message")
    }
}