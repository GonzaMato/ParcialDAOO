package org.errors

class BaseNotification() : Notification {
    override fun sendNotification(message: String) : Message{
        return Message("BaseNotification", message)
    }
}