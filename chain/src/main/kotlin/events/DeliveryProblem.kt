package org.example.events

class DeliveryProblem(
    private val deliveryID : Long,
    private val errorCode : String,
    private val description : String,
    private val location : String
) : Event() {

    fun getDeliveryID() : Long {
        return deliveryID
    }

    fun getErrorCode() : String {
        return errorCode
    }
}