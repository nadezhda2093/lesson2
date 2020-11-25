package org.example.lesson2.service

import org.example.lesson2.dto.EmployeeDTO
import org.example.lesson2.dto.FullPositionDTO
import org.example.lesson2.dto.IdentifierDTO
import org.example.lesson2.dto.PositionDTO
import org.example.lesson2.repository.PositionRepository
import org.example.lesson2.service.mapper.PositionMapper
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class PositionService(
        private val positionRepository: PositionRepository,
        private val positionMapper: PositionMapper
) {

    fun getAllPositions(): List<FullPositionDTO> {
        return positionRepository.findAll()
                .map { positionMapper.map(it) }
    }

    fun getPositionById(id: Long): FullPositionDTO {
        return positionRepository.findById(id)
                .map { positionMapper.map(it) }
                .orElseThrow { EntityNotFoundException() }

    }

}