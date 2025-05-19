package org.example

import org.example.eventHandler.HandlerRegistry
import org.example.events.Payment
import org.example.models.PayMethod


fun main() {

    val handlers = HandlerRegistry

    handlers.handleEvent(Payment(
        orderId = 1,
        amount = 100.0,
        paymentMethod = PayMethod.CASH,
        date = java.util.Date()
    ))
 }
