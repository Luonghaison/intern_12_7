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
        return new Employee(dto.getId(),dto.getName(), dto.getEmail(),dto.getDepartment(),dto.getRoles());
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        return new EmployeeDto(entity.getId(), entity.getName(), entity.getEmail(),entity.getDepartment(),entity.getRoles());
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        List<Employee> entityList = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
    @Override
    public List<EmployeeDto> toDto(List<Employee> entityList) {
        List<EmployeeDto> dtoList = new ArrayList<>();
        for (Employee entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
