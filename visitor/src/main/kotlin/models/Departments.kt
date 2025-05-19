package org.example.models

import org.example.Visitor.Visitor

class Departments(
    private val employeeList : List<Employee>,
    private val budget : Double,
) : Visitable {
    override fun accept(v: Visitor) {
        v.visitDepartments(this)
    }

    fun getEmployeeList(): List<Employee> {
        return employeeList
    }

    fun getBudget(): Double {
        return budget
    }
}