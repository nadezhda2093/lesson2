package org.example.lesson2.domain

import org.example.lesson2.exception.EntityNotPersistedException
import java.util.Collections
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Position(
    val name: String,
    val grade: String,
    val minSalary: Int,
    val maxSalary: Int
) {

    @Id
    var id: Long? = null
        protected set

    val persistentId: Long
        get() = id ?: throw EntityNotPersistedException()

    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
    private var _employees: MutableSet<Employee> = mutableSetOf()

    val employees: Set<Employee>
        get() = Collections.unmodifiableSet(_employees)

    fun addEmployee(employee: Employee) {
        employee.position = this
        _employees.add(employee)
    }
}