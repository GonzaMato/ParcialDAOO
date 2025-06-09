package org.errors.events

import org.errors.models.PayMethod
import org.errors.models.Product

class NewOrder(
    private val clientId : Long,
    private val productList : List<Product>,
    private val direction : String,
    private val payMethod : PayMethod
) : Event() {

    fun getClientId() : Long{
        return clientId
    }

    fun productList() : List<Product> {
        return productList
    }

    fun direction() : String{
        return direction
    }

    fun payMethod() : PayMethod{
        return payMethod
    }
}