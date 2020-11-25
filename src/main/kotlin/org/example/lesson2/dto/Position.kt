package org.example.lesson2.dto

open class PositionDTO(
        val name: String,
        val grade: String,
        val minSalary: Int,
        val maxSalary: Int
)

class FullPositionDTO(
    val id: Long,
    name: String,
    grade: String,
    minSalary: Int,
    maxSalary: Int,
) : PositionDTO(name, grade, minSalary, maxSalary)