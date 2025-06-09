package org.errors.Visitor

import org.errors.models.Departments
import org.errors.models.Employee
import org.errors.models.Project

class ReportVisitor(
    private var report : String = "",
) : Visitor {

    override fun visitEmployee(employee: Employee) {
        report += "Employee: ${employee.getName()}, Salary: ${employee.getSalary()}, Worked Hours: ${employee.getWorkedHours()}\n"
    }

    override fun visitDepartments(departments: Departments) {
        report += "Departments Budget: ${departments.getBudget()}\n"
        generateEmployeeReport(departments.getEmployeeList())
    }

    override fun visitProjects(project: Project) {
        report += "Project State: ${project.getState()}\n"
        report += "Project Deadlines: ${project.getDeadlines().joinToString(", ")}\n"
        report += "Project Employees:\n"
        generateEmployeeReport(project.getEmployeeList())
    }

    private fun generateEmployeeReport(employeeList : List<Employee>) {
        for (employee in employeeList) {
            employee.accept(this)
        }
    }

    fun getReport(): String {
        return report
    }
}