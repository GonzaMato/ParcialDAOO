package org.example

class ConsoleLogger() : Logger {
    override fun logEvent(message: String) {
        println(message)
    }
}