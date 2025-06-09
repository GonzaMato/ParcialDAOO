import org.errors.Visitor.ReportVisitor
import org.errors.models.Departments
import org.errors.models.Employee
import org.errors.models.Project
import org.errors.models.State
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class ReportVisitorTest {


    @Test
    fun testEmployeeReport(){
        val employee = Employee("John Doe", 50000.0, 40.0)
        val reportVisitor = ReportVisitor()

        employee.accept(reportVisitor)

        val report = reportVisitor.getReport()

        assertEquals("Employee: John Doe, Salary: 50000.0, Worked Hours: 40.0\n", report)
    }

    @Test
    fun testDepartmentsReport(){
        val employee1 = Employee("John Doe", 50000.0, 40.0)
        val employee2 = Employee("Jane Smith", 60000.0, 35.0)
        val departments = Departments(listOf(employee1, employee2), 1000000.0)
        val reportVisitor = ReportVisitor()

        departments.accept(reportVisitor)

        val report = reportVisitor.getReport()

        assertEquals("Departments Budget: 1000000.0\nEmployee: John Doe, Salary: 50000.0, Worked Hours: 40.0\nEmployee: Jane Smith, Salary: 60000.0, Worked Hours: 35.0\n", report)
    }

    @Test
    fun testProjectReport(){
        val employee1 = Employee("John Doe", 50000.0, 40.0)
        val employee2 = Employee("Jane Smith", 60000.0, 35.0)
        val project = Project(listOf(employee1, employee2), listOf(Date()) , State.ONGOING)
        val reportVisitor = ReportVisitor()

        project.accept(reportVisitor)

        val report = reportVisitor.getReport()

        assertEquals("Project State: ONGOING\n" +
                "Project Deadlines: Mon May 19 15:52:31 ART 2025\n" +
                "Project Employees:\n" +
                "Employee: John Doe, Salary: 50000.0, Worked Hours: 40.0\n" +
                "Employee: Jane Smith, Salary: 60000.0, Worked Hours: 35.0\n", report)
    }
}