package org.errors.eventHandler

import org.errors.ConsoleLogger
import org.errors.Logger
import org.errors.events.Event
import org.errors.events.NewOrder

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