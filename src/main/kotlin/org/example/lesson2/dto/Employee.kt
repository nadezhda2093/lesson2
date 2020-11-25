package org.example.lesson2.dto

open class EmployeeDTO(
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val positionId: Long
)

class FullEmployeeDTO(
    val id: Long,
    email: String,
    firstName: String,
    lastName: String,
    middleName: String?,
    positionId: Long
) : EmployeeDTO(email, firstName, lastName, middleName, positionId)