package org.errors.Visitor.statistics

import org.errors.Visitor.Visitor
import org.errors.models.Departments
import org.errors.models.Employee
import org.errors.models.Project

class StatisticsVisitor(
    private var statistics : Statistics = Statistics(0.0, 0.0)
) : Visitor {
    private var employeesVisited = 0

    internal fun getEmployeeVisited() = employeesVisited

    override fun visitEmployee(employee: Employee) {
        statistics.totalHours += employee.getWorkedHours()
        statistics.salariesPaid += employee.getSalary()
        employeesVisited++
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