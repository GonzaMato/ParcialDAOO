package org.example.eventHandler

import org.example.ConsoleLogger
import org.example.Logger
import org.example.events.Event
import org.example.events.NewOrder

object NewProductHandler : Handler() {
    var logger : Logger = ConsoleLogger()

    override fun process(event: Event): Boolean {
        if (event is NewOrder) {
            logger.logEvent("New Product event: Client id = ${event.getClientId()}" )
            return true
        }
        return false
    }

}