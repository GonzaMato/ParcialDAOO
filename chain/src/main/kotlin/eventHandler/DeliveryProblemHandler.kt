package org.errors.eventHandler

import org.errors.ConsoleLogger
import org.errors.Logger
import org.errors.events.DeliveryProblem
import org.errors.events.Event

object DeliveryProblemHandler : Handler(){
    var logger : Logger = ConsoleLogger()


    override fun process(event: Event): Boolean {
        if (event is DeliveryProblem){
            logger.logEvent("Delivery Problem event: Delivery ID: ${event.getDeliveryID()} - Error Code: ${event.getErrorCode()}")
            return true
        }

        return false
    }
}