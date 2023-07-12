package com.example.day11_7.Service;

import com.example.day11_7.Model.Department;
import com.example.day11_7.Model.Employee;
import com.example.day11_7.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Page<Department> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(),5,sort);
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
