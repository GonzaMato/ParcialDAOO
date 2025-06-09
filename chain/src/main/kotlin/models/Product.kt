package org.errors.models

class Product(
    private val price : Double,
    private val name : String
) {

    fun getName() : String{
        return name
    }

    fun getPrice() : Double{
        return price
    }
}