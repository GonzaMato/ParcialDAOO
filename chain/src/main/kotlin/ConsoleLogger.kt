package org.errors

class ConsoleLogger() : Logger {
    override fun logEvent(message: String) {
        println(message)
    }
}