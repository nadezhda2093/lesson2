package org.example.lesson2.repository;

import org.example.lesson2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositoryBase extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByFirstNameContaining(String firstName);
}
