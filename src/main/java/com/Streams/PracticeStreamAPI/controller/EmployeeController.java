package com.Streams.PracticeStreamAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Streams.PracticeStreamAPI.domain.Employee;
import com.Streams.PracticeStreamAPI.repository.EmployeeRepo;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/nameStarta")
    public ResponseEntity<List<Employee>> getEmployeeStartNameWithA() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> startWithA = employees.stream()
                .filter((emp) -> emp.getName().toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(startWithA);
    }

}
