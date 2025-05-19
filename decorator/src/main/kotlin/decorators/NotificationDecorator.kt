package org.example.decorators

import org.example.Message
import org.example.Notification

abstract class NotificationDecorator(private val notification: Notification) : Notification {

    override fun sendNotification(message: String): Message {
        return notification.sendNotification(message)
    }

}