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

    @GetMapping("/managerNameStartA")
    public ResponseEntity<List<Employee>> getManagerStartNamewithA() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> managerNameStartWithA = employees.stream()
                .filter((emp) -> emp.getManagerName().toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(managerNameStartWithA);
    }

    @GetMapping("/getEmployeeBySkill")
    public ResponseEntity<List<Employee>> getEmployeeBySkill() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> skills = employees.stream()
                .filter((emp) -> emp.getSkills().toString().toLowerCase().equalsIgnoreCase("JAVA"))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

    @GetMapping("/getAllEmpName")
    public ResponseEntity<List<String>> getEmployeesNames() {
        List<Employee> employees = employeeRepo.findAll();

        List<String> names = employees.stream()
                .map(emp -> emp.getName().toString())
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(names);
    }

    @GetMapping("/departmentName")
    public ResponseEntity<List<String>> getDepartment() {
        List<Employee> employees = employeeRepo.findAll();

        List<String> department = employees.stream()
                .map(emp -> emp.getDepartment().toString()).distinct().toList();

        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<String>> getSkills() {
        List<Employee> employees = employeeRepo.findAll();
        List<String> skills = employees.stream()
        .map(emp -> emp.getSkills().toString()).distinct().toList();

        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

}
