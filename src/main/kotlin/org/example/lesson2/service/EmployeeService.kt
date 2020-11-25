package org.example.lesson2.service

import org.example.lesson2.dto.EmployeeDTO
import org.example.lesson2.dto.FullEmployeeDTO
import org.example.lesson2.dto.IdentifierDTO
import org.example.lesson2.repository.EmployeeRepository
import org.example.lesson2.repository.PositionRepository
import org.example.lesson2.service.mapper.EmployeeMapper
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val positionRepository: PositionRepository,
    private val employeeMapper: EmployeeMapper,
) {
    fun getAllEmployees(): List<FullEmployeeDTO> {
        return employeeRepository.findAll()
                .map { employeeMapper.map(it) }
    }

    fun getEmployeeById(id: Long): FullEmployeeDTO {
        return employeeRepository.findById(id)
            .map { employeeMapper.map(it) }
            .orElseThrow { EntityNotFoundException() }

    }

    fun getEmployeeByEmail(email: String): List<FullEmployeeDTO> {
        return employeeRepository.findAllByEmail(email)
                .map { employeeMapper.map(it) }
    }

    fun getEmployeeByFirstName(firstName: String): List<FullEmployeeDTO> {
        return employeeRepository.findAllByFirstName(firstName)
                .map { employeeMapper.map(it) }
    }

    fun getEmployeeByLastName(lastName: String): List<FullEmployeeDTO> {
        return employeeRepository.findAllByLastName(lastName)
                .map { employeeMapper.map(it) }
    }

    fun getEmployeeByMiddleName(middleName: String): List<FullEmployeeDTO> {
        return employeeRepository.findAllByMiddleName(middleName)
                .map { employeeMapper.map(it) }
    }

    fun createEmployee(employeeDTO: EmployeeDTO): IdentifierDTO<Long> {
        return employeeMapper.map(employeeDTO) { positionRepository.getOne(it) }
            .let { employeeRepository.save(it) }
            .let { IdentifierDTO(it.persistentId) }
    }

}