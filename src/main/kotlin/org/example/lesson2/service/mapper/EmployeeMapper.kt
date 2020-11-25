package org.example.lesson2.service.mapper

import org.example.lesson2.domain.Employee
import org.example.lesson2.domain.Position
import org.example.lesson2.dto.EmployeeDTO
import org.example.lesson2.dto.FullEmployeeDTO
import org.springframework.stereotype.Service

@Service
class EmployeeMapper {

    fun map(employee: Employee): FullEmployeeDTO {
        return FullEmployeeDTO(
            employee.persistentId,
            employee.email,
            employee.firstName,
            employee.lastName,
            employee.middleName,
            employee.position.persistentId,
        )
    }

    fun map(employeeDTO: EmployeeDTO, producePosition: (Long) -> Position): Employee {
        return Employee(
            employeeDTO.email,
            employeeDTO.firstName,
            employeeDTO.lastName,
            employeeDTO.middleName,
            producePosition(employeeDTO.positionId)
        )
    }
}