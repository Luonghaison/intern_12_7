package com.example.day11_7.service;

import com.example.day11_7.model.Employee;
import com.example.day11_7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> findAll(Pageable pageable, Sort sort) {
        return employeeRepository.findAll(pageable);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

}

