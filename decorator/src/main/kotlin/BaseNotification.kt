package org.example

class BaseNotification() : Notification {
    override fun sendNotification(message: String) : Message{
        return Message("BaseNotification", message)
    }
}