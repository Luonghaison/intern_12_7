package com.example.day11_7.Repository;

import com.example.day11_7.Model.Department;
import com.example.day11_7.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("SELECT d FROM Department d WHERE LOWER(d.name) LIKE %:name%")
    Page<Department> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
