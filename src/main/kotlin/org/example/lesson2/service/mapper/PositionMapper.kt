package org.example.lesson2.service.mapper

import org.example.lesson2.domain.Employee
import org.example.lesson2.domain.Position
import org.example.lesson2.dto.EmployeeDTO
import org.example.lesson2.dto.FullPositionDTO
import org.example.lesson2.dto.PositionDTO
import org.springframework.stereotype.Service

@Service
class PositionMapper {

    fun map(position: Position): FullPositionDTO {
        return FullPositionDTO(
                position.persistentId,
                position.name,
                position.grade,
                position.maxSalary,
                position.minSalary,
        )
    }

    fun map(positionDTO: PositionDTO): Position {
            return Position(
                positionDTO.name,
                positionDTO.grade,
                positionDTO.maxSalary,
                positionDTO.minSalary
        )
    }
}