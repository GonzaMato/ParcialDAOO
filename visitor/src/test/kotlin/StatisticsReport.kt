import org.example.Visitor.statistics.StatisticsVisitor
import org.example.models.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StatisticsReport {


    @Test
    fun testEmployeeStatistics(){
        val employee = Employee("John Doe", 50000.0, 40.0)
        val statisticsVisitor = StatisticsVisitor()

        employee.accept(statisticsVisitor)

        val statistics = statisticsVisitor.getStatistics()

        assertEquals(40.0, statistics.totalHours)
        assertEquals(50000.0, statistics.salariesPaid)
    }

    @Test
    fun testDepartmentStatistics() {
        val employee1 = Employee("John Doe", 50000.0, 40.0)
        val employee2 = Employee("Jane Smith", 60000.0, 35.0)
        val departments = org.example.models.Departments(listOf(employee1, employee2), 1000000.0)
        val statisticsVisitor = StatisticsVisitor()

        departments.accept(statisticsVisitor)

        val statistics = statisticsVisitor.getStatistics()

        assertEquals(75.0, statistics.totalHours)
        assertEquals(110000.0, statistics.salariesPaid)
    }

    @Test
    fun testProjectStatistics() {
        val employee1 = Employee("John Doe", 50000.0, 40.0)
        val employee2 = Employee("Jane Smith", 60000.0, 35.0)
        val project = org.example.models.Project(listOf(employee1, employee2), listOf(java.util.Date()), org.example.models.State.ONGOING)
        val statisticsVisitor = StatisticsVisitor()

        project.accept(statisticsVisitor)

        val statistics = statisticsVisitor.getStatistics()

        assertEquals(75.0, statistics.totalHours)
    }
}