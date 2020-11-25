package org.example.lesson2.api

import org.example.lesson2.dto.FullPositionDTO
import org.example.lesson2.service.PositionService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/position", produces = [MediaType.APPLICATION_JSON_VALUE])
class PositionController(private val positionService: PositionService) {

    @GetMapping
    fun getAllPositions(): List<FullPositionDTO> = positionService.getAllPositions()

    @GetMapping("/{id}")
    fun getPositionById(@PathVariable id: Long): FullPositionDTO = positionService.getPositionById(id)

}