package com.example.day11_7.service;

import com.example.day11_7.model.Department;
import com.example.day11_7.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Page<Department> findAll(Pageable pageable, Sort sort) {
        return departmentRepository.findAll(pageable);
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public Page<Department> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return departmentRepository.findByNameContainingIgnoreCase(name, pageable);
    }

}
