package org.example.lesson2.api

import org.example.lesson2.domain.Employee
import org.example.lesson2.domain.Position
import org.example.lesson2.dto.EmployeeDTO
import org.example.lesson2.dto.FullEmployeeDTO
import org.example.lesson2.dto.IdentifierDTO
import org.example.lesson2.service.EmployeeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees", produces = [MediaType.APPLICATION_JSON_VALUE])
class EmployeeController(private val employeeService: EmployeeService) {


    @GetMapping
    fun getAllEmployees(): List<FullEmployeeDTO> = employeeService.getAllEmployees()

//    @GetMapping
//    fun getAllEmployeesTest(@RequestParam(value = "email", defaultValue = "tes3@r.et") email: String,
//                            @RequestParam(value = "firstName", defaultValue = "Ivan") firstName: String,
//                            @RequestParam(value = "lastName", defaultValue = "Ivanivich") lastName: String,
//                            @RequestParam(value = "middleName", defaultValue = "Ivanov") middleName: String,
//                            @RequestParam(value = "position", defaultValue = "2") position: Position): Employee {
//        return Employee(email, firstName, lastName, middleName, position)
//    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): FullEmployeeDTO = employeeService.getEmployeeById(id)

    @GetMapping("/email/{email}")
    fun getEmployeeByEmail(@PathVariable email: String): List<FullEmployeeDTO> = employeeService.getEmployeeByEmail(email)

    @GetMapping("/firstName/{firstName}")
    fun getEmployeeByFirstName(@PathVariable firstName: String): List<FullEmployeeDTO> = employeeService.getEmployeeByFirstName(firstName)

    @GetMapping("/lastName/{lastName}")
    fun getEmployeeByLastName(@PathVariable lastName: String): List<FullEmployeeDTO> = employeeService.getEmployeeByLastName(lastName)

    @GetMapping("/middleName/{middleName}")
    fun getEmployeeByMiddleName(@PathVariable middleName: String): List<FullEmployeeDTO> = employeeService.getEmployeeByMiddleName(middleName)

    @PostMapping
    fun createEmployee(@RequestBody employeeDTO: EmployeeDTO): IdentifierDTO<Long> = employeeService.createEmployee(employeeDTO)
}