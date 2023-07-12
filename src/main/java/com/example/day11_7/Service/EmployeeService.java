package com.example.day11_7.Service;

import com.example.day11_7.Model.Employee;
import com.example.day11_7.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service

public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(),5,sort);
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

    public boolean emailExist(String email) {
        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    }

