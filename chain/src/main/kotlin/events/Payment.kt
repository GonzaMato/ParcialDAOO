package org.example.events

import org.example.models.PayMethod
import java.util.Date

class Payment(
    private val orderId : Long,
    private val amount : Double,
    private val paymentMethod : PayMethod,
    private val date : Date
) : Event() {

    fun getOrderId() : Long {
        return orderId
    }

    fun getAmount() : Double {
        return amount
    }

    fun getPaymentMethod() : PayMethod {
        return paymentMethod
    }

    fun getDate() : Date {
        return date
    }
}