package org.example.Visitor

import org.example.models.Departments
import org.example.models.Employee
import org.example.models.Project

class StatisticsVisitor() : Visitor {
    override fun visitEmployee(employee: Employee) {
        TODO("Not yet implemented")
    }

    override fun visitDepartments(departments: Departments) {
        TODO("Not yet implemented")
    }

    override fun visitProjects(project: Project) {
        TODO("Not yet implemented")
    }
}