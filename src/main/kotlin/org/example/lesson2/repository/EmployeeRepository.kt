package org.example.lesson2.repository

import org.example.lesson2.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {

    fun findAllByEmail(email: String): List<Employee>
    fun findAllByFirstName(firstName: String): List<Employee>
    fun findAllByLastName(lastName: String): List<Employee>
    fun findAllByMiddleName(middleName: String): List<Employee>
}