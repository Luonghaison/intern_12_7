package com.example.day11_7.Maper;

import com.example.day11_7.DTO.EmployeeDto;
import com.example.day11_7.Model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper implements EntityMaper<EmployeeDto, Employee> {
    @Override
    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(dto.getDepartment());
        entity.setRoles(dto.getRoles());
        entity.setDepartmentId(dto.getDepartmentId());
        return entity;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setDepartment(entity.getDepartment());
        dto.setRoles(entity.getRoles());
        dto.setDepartmentId(entity.getDepartmentId());
        return dto;
    }


    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Employee> entityList = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
    @Override
    public List<EmployeeDto> toDto(List<Employee> entityList) {
        if (entityList == null) {
            return null;
        }
        List<EmployeeDto> dtoList = new ArrayList<>();
        for (Employee entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
