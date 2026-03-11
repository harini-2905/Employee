package com.example.Employee.controller;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto dto) {
        return employeeService.create(dto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/page")
    public List<EmployeeDto> getEmployeesWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return employeeService.getEmployeesWithPagination(page, size);
    }

    @PutMapping
    public EmployeeDto updateEmployee(@Valid @RequestBody EmployeeDto dto) {
        return employeeService.update(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.delete(id);
        return "Employee deleted successfully";
    }
}
