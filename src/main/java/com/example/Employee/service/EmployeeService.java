package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployeesWithPagination(int page, int size);

    EmployeeDto update(EmployeeDto employeeDto);

    void delete(Long id);
}