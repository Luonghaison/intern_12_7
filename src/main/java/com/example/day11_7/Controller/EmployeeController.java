package com.example.day11_7.Controller;

import com.example.day11_7.DTO.EmployeeDto;
import com.example.day11_7.Maper.EmployeeMapper;
import com.example.day11_7.Model.Employee;
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

import java.util.List;
    @RestController
    @RequestMapping("/api")
    public class EmployeeController {
        @Autowired
        private EmployeeService employeeService;

        @Autowired
        private EmployeeMapper employeeMapper;

        @GetMapping("/employee")
        public ResponseEntity<Page<EmployeeDto>> getAllEmployees(
                @RequestParam(name = "name", required = false) String name,
                @PageableDefault(sort = { "id" }, direction = Sort.Direction.ASC) Pageable pageable,
                @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort) {
            Page<Employee> employeePage;
            if (name != null && !name.isEmpty()) {
                employeePage = employeeService.findByNameContainingIgnoreCase(name, pageable);
            } else {
                employeePage = employeeService.getAll(pageable, sort);
            }
            Page<EmployeeDto> employeeDtoPage = employeePage.map(employeeMapper::toDto);
            return ResponseEntity.ok(employeeDtoPage);
        }

        @PostMapping("/employee")
        public ResponseEntity<?> create(@RequestBody Employee employee) {
            boolean checkEmail = employeeService.emailExist(employee.getEmail());
            if (checkEmail) {
                return new ResponseEntity<>("email đã tồn tại xin thử lại! ", HttpStatus.FAILED_DEPENDENCY);
            }
            employeeService.save(employee);
            EmployeeDto employeeDto = employeeMapper.toDto(employee);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }

        @PutMapping("/employee")
        public ResponseEntity<?> edit(@RequestBody Employee employee) {
            Employee employeeByEmail = employeeService.findByEmail(employee.getEmail());
            if (employeeByEmail != null && employeeByEmail.getId() != employee.getId()) {
                return new ResponseEntity<>("email đã tồn tại", HttpStatus.NOT_FOUND);
            }
            employeeService.save(employee);
            EmployeeDto employeeDto = employeeMapper.toDto(employee);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }

        @DeleteMapping("/employee/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
            employeeService.deleteById(id);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        }

        @GetMapping("/employee/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
            Employee employee = employeeService.findById(id);
            if (employee == null) {
                return new ResponseEntity<>("Không tìm thấy id", HttpStatus.NOT_FOUND);
            }
            EmployeeDto employeeDto = employeeMapper.toDto(employee);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }
    }