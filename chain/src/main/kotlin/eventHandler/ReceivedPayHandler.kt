package org.example.eventHandler

import org.example.ConsoleLogger
import org.example.Logger
import org.example.events.Event
import org.example.events.Payment

object ReceivedPayHandler : Handler() {
    var logger : Logger = ConsoleLogger()

    override fun process(event: Event): Boolean {
        if (event is Payment){
            logger.logEvent("Received Payment event: Order ID = ${event.getOrderId()} - Amount = ${event.getAmount()} - Payment Method = ${event.getPaymentMethod()}")
            return true
        }
        return false
    }
}