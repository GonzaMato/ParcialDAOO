package org.example.Visitor

import org.example.models.Departments
import org.example.models.Employee
import org.example.models.Project

interface Visitor {
    fun visitEmployee(employee: Employee)
    fun visitDepartments(departments: Departments)
    fun visitProjects(project : Project)
}