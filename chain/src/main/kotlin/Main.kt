package org.errors

import org.errors.eventHandler.HandlerRegistry
import org.errors.events.Payment
import org.errors.models.PayMethod


fun main() {

    val handlers = HandlerRegistry

    handlers.handleEvent(Payment(
        orderId = 1,
        amount = 100.0,
        paymentMethod = PayMethod.CASH,
        date = java.util.Date()
    ))
 }
