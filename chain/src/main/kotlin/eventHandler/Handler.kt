package org.example.eventHandler

import org.example.events.Event

sealed class Handler(private var next : Handler? = null) {
    fun setNextHandler(handler: Handler) : Handler {
        next = handler
        return handler
    }

    fun handle(event : Event)  {
        if (!process(event)) {
            next?.handle(event)
        }
    }

    abstract fun process(event : Event) : Boolean

}