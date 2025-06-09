package org.errors.models

import org.errors.Visitor.Visitor


class Employee(
    private val name: String,
    private val salary : Double,
    private val workedHours : Double,
) : Visitable {
    override fun accept(v: Visitor) {
        v.visitEmployee(this)
    }

    fun getName(): String {
        return name
    }

    fun getSalary(): Double {
        return salary
    }

    fun getWorkedHours(): Double {
        return workedHours
    }
}