package org.example.eventHandler

import org.example.ConsoleLogger
import org.example.Logger
import org.example.events.DeliveryProblem
import org.example.events.Event

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