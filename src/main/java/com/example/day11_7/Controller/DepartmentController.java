package com.example.day11_7.Controller;

import com.example.day11_7.DTO.DepartmentDto;
import com.example.day11_7.DTO.EmployeeDto;
import com.example.day11_7.Maper.DepartmentMapper;
import com.example.day11_7.Maper.EmployeeMapper;
import com.example.day11_7.Model.Department;
import com.example.day11_7.Model.Employee;
import com.example.day11_7.Service.DepartmentService;
import com.example.day11_7.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/department")
    public ResponseEntity<Page<DepartmentDto>> findAllDepartment(
            @RequestParam(name = "name", required = false) String name,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.ASC) Pageable pageable,
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort) {
        Page<Department> departmentPage;
        if (name != null && !name.isEmpty()) {
            departmentPage = departmentService.findByNameContainingIgnoreCase(name, pageable);
        } else {
            departmentPage = departmentService.findAll(pageable, sort);
        }
        Page<DepartmentDto> departmentDtoPage = departmentPage.map(departmentMapper::toDto);
        return ResponseEntity.ok(departmentDtoPage);
    }

    @PostMapping("/department")
    public ResponseEntity<?> create(@RequestBody Department department) {
        departmentService.save(department);
        DepartmentDto departmentDto = departmentMapper.toDto(department);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PutMapping("/department")
    public ResponseEntity<?> edit(@RequestBody Department department) {
        departmentService.save(department);
        DepartmentDto departmentDto = departmentMapper.toDto(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Nhập sai id",HttpStatus.NOT_FOUND);
        }else { departmentService.deleteById(id);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);}
    }
}
