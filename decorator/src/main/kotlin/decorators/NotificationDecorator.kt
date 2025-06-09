package org.errors.decorators

import org.errors.Message
import org.errors.Notification

abstract class NotificationDecorator(private val notification: Notification) : Notification {

    override fun sendNotification(message: String): Message {
        return notification.sendNotification(message)
    }

}