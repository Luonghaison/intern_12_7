package com.example.day11_7.Repository;

import com.example.day11_7.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE %:name%")
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
