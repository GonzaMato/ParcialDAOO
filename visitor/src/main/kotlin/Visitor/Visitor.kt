package org.errors.Visitor

import org.errors.models.Departments
import org.errors.models.Employee
import org.errors.models.Project

interface Visitor {
    fun visitEmployee(employee: Employee)
    fun visitDepartments(departments: Departments)
    fun visitProjects(project : Project)
}