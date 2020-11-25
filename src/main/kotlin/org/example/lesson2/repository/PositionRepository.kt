package org.example.lesson2.repository

import org.example.lesson2.domain.Position
import org.springframework.data.jpa.repository.JpaRepository

interface PositionRepository : JpaRepository<Position, Long> {
}

