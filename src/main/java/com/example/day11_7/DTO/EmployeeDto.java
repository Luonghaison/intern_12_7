package com.example.day11_7.DTO;

import com.example.day11_7.Model.Department;
import com.example.day11_7.Model.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private Department department;
    private Set<Role> roles = new HashSet<>();
    private Long departmentId;
    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String email, Department department, Set<Role> roles, Long departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.roles = roles;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
