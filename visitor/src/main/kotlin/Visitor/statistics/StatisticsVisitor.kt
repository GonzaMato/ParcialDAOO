package org.example.Visitor.statistics

import org.example.Visitor.Visitor
import org.example.models.Departments
import org.example.models.Employee
import org.example.models.Project

class StatisticsVisitor(
    private var statistics : Statistics = Statistics(0.0, 0.0)
) : Visitor {
    override fun visitEmployee(employee: Employee) {
        statistics.totalHours += employee.getWorkedHours()
        statistics.salariesPaid += employee.getSalary()
    }

    override fun visitDepartments(departments: Departments) {
        generateEmployeeStatistics(departments.getEmployeeList())
    }

    override fun visitProjects(project: Project) {
        generateEmployeeStatistics(project.getEmployeeList())
    }

    private fun generateEmployeeStatistics(employeeList : List<Employee>) {
        for (employee in employeeList) {
            employee.accept(this)
        }
    }

    fun getStatistics(): Statistics {
        return statistics
    }
}