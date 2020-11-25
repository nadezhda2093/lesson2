package org.example.lesson2.domain

import org.example.lesson2.exception.EntityNotPersistedException
import org.hibernate.annotations.NaturalId
import javax.persistence.*

@Entity
class Employee(
        @NaturalId
        var email: String,
        var firstName: String,
        var lastName: String,
        var middleName: String?,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(referencedColumnName = "id")
        var position: Position
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    val persistentId: Long
        get() = id ?: throw EntityNotPersistedException()
}

