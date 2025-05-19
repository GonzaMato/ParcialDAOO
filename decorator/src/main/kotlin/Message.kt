package org.example

class Message(
    private val title: String,
    private val body: String
){

    fun getTitle() : String {
        return title
    }

    fun getBody() : String {
        return body
    }
}