package org.example.models

import org.example.Visitor.Visitor
import java.util.Date


enum class State {
    ONGOING,
    COMPLETED,
    PENDING
}

class Projects(
    private val employeeList : List<Employee>,
    private val deadlines : List<Date>,
    private val state : State
) : Visitable{
    override fun accept(v: Visitor) {
        v.visitProjects()
    }
}