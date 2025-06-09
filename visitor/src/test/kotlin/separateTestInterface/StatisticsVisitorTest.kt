package separateTestInterface

import org.errors.Visitor.statistics.StatisticsVisitor
import org.errors.models.Departments
import org.errors.models.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StatisticsVisitorTest : StatisticsVisitorAccessor {

    private lateinit var visitor: StatisticsVisitor

    @BeforeEach
    fun setUp() {
        visitor = StatisticsVisitor()
    }

    override fun employeesVisited(): Int {
        return visitor.getEmployeeVisited()
    }

    @Test
    fun testVisitEmployee() {
        val alice = Employee(name = "Alice", salary = 1000.0, workedHours = 160.0)
        val bob   = Employee(name = "Bob",   salary = 1200.0, workedHours = 170.0)

        alice.accept(visitor)
        bob.accept(visitor)

        val stats = visitor.getStatistics()
        assertEquals(330.0, stats.totalHours, 0.0001)
        assertEquals(2200.0, stats.salariesPaid, 0.0001)

        assertEquals(2, employeesVisited())
    }

    @Test
    fun testVisitDepartment() {
        val alice = Employee(name = "Alice", salary = 1000.0, workedHours = 160.0)
        val bob   = Employee(name = "Bob",   salary = 1200.0, workedHours = 170.0)
        val department = Departments(listOf(alice, bob), budget = 50000.0)

        department.accept(visitor)

        val stats = visitor.getStatistics()
        assertEquals(330.0, stats.totalHours, 0.0001)
        assertEquals(2200.0, stats.salariesPaid, 0.0001)

        assertEquals(2, employeesVisited())
    }


}