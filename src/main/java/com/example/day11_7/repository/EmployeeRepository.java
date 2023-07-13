package com.example.day11_7.repository;

import com.example.day11_7.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Employee findByEmail(String email);

    boolean existsByEmail(String email);

}
