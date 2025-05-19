package org.example

class MemoryLogger(
    private var log : String = ""
) : Logger{

    override fun logEvent(message : String){
        log += message
    }

    fun getLog() : String {
        return log
    }
}