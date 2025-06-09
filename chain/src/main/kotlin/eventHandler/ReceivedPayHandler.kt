package org.errors.eventHandler

import org.errors.ConsoleLogger
import org.errors.Logger
import org.errors.events.Event
import org.errors.events.Payment

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