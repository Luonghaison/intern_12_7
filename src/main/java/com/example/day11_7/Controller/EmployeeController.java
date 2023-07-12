package com.example.day11_7.Controller;

import com.example.day11_7.Model.Employee;
import com.example.day11_7.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/api")
    public class EmployeeController {
        @Autowired
        private EmployeeService employeeService;

        @PostMapping("/employee")
        public ResponseEntity<?> create(@RequestBody Employee employee) {
            boolean checkEmail = employeeService.emailExist(employee.getEmail());
            if (checkEmail) {
                return new ResponseEntity<>("email đã tồn tại xin thử lại! ", HttpStatus.FAILED_DEPENDENCY);
            }
            employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/employee")
        public ResponseEntity<?> edit(@RequestBody Employee employee) {
            Employee employeeByEmail = employeeService.findByEmail(employee.getEmail());
            if (employeeByEmail != null && employeeByEmail.getId() != employee.getId()) {
                return new ResponseEntity<>("email đã tồn tại", HttpStatus.NOT_FOUND);
            }
            employeeService.save(employee);
            return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
        }

        @DeleteMapping("/employee/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
            employeeService.deleteById(id);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        }

        @GetMapping("/employee")
        public ResponseEntity<?> getall(Pageable pageable) {
            Page<Employee> employeeList = employeeService.getAll(pageable);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }

        @GetMapping("/employee/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
            Employee employee = employeeService.findById(id);
            if (employee == null) {
                return new ResponseEntity<>("Không tìm thấy id", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        @GetMapping("/employee/search")
        public ResponseEntity<List<Employee>> searchByName(@RequestParam("name") String name) {
            List<Employee> employee = employeeService.findByNameContainingIgnoreCase(name);
            return ResponseEntity.ok().body(employee);
        }
    }