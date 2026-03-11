package com.example.Employee.service.impl;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.entity.Employee;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.mapper.EmployeeMapper;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto dto) {

        Employee employee = EmployeeMapper.mapToEntity(dto);

        Employee savedEmployee = employeeRepository.save(employee);

        logger.info("Employee created with id {}", savedEmployee.getId());

        return EmployeeMapper.mapToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {

        logger.info("Fetching employee with id {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));

        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        logger.info("Fetching all employees");

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesWithPagination(int page, int size) {

        logger.info("Fetching employees page {} size {}", page, size);

        List<Employee> employees =
                employeeRepository.findAll(PageRequest.of(page, size)).getContent();

        return employees.stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
    }

    @Override
    public EmployeeDto update(EmployeeDto dto) {

        logger.info("Updating employee with id {}", dto.getId());

        Employee employee = employeeRepository.findById(dto.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + dto.getId()));

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());

        Employee updated = employeeRepository.save(employee);

        return EmployeeMapper.mapToDto(updated);
    }

    @Override
    public void delete(Long id) {

        logger.info("Deleting employee with id {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));

        employeeRepository.delete(employee);
    }
}