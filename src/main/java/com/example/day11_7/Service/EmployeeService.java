package com.example.day11_7.Service;

import com.example.day11_7.Model.Employee;
import com.example.day11_7.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(),5);
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

    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public boolean emailExist(String email) {
        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Employee findByEmail(String email) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }
}

