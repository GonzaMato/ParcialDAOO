package org.errors.models

import org.errors.Visitor.Visitor

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