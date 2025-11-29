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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employees")
@Tag(name = "EMployeeAPI", description = "Employees GET APIS")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/all")
    @Operation(summary = "Get All Employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/nameStarta")
    @Operation(summary = "Get Employee Start with name A")
    public ResponseEntity<List<Employee>> getEmployeeStartNameWithA() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> startWithA = employees.stream()
                .filter((emp) -> emp.getName().toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(startWithA);
    }

    @GetMapping("/managerNameStartA")
    @Operation(summary = "Get ManagerName Start with name M")
    public ResponseEntity<List<Employee>> getManagerStartNamewithA() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> managerNameStartWithA = employees.stream()
                .filter((emp) -> emp.getManagerName().toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(managerNameStartWithA);
    }

    @GetMapping("/getEmployeeBySkill")
    @Operation(summary = "Get Employee By Skill name JAVA")
    public ResponseEntity<List<Employee>> getEmployeeBySkill() {
        List<Employee> employees = employeeRepo.findAll();

        List<Employee> skills = employees.stream()
                .filter((emp) -> emp.getSkills().toString().toLowerCase().equalsIgnoreCase("JAVA"))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

    @GetMapping("/getAllEmpName")
    @Operation(summary = "Get Employees Name")
    public ResponseEntity<List<String>> getEmployeesNames() {
        List<Employee> employees = employeeRepo.findAll();

        List<String> names = employees.stream()
                .map(emp -> emp.getName().toString())
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(names);
    }

    @GetMapping("/departmentName")
    @Operation(summary = "Get Department Names")
    public ResponseEntity<List<String>> getDepartment() {
        List<Employee> employees = employeeRepo.findAll();

        List<String> department = employees.stream()
                .map(emp -> emp.getDepartment().toString()).distinct().toList();

        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @GetMapping("/skills")
    @Operation(summary = "Get Skills Names")
    public ResponseEntity<List<String>> getSkills() {
        List<Employee> employees = employeeRepo.findAll();
        List<String> skills = employees.stream()
        .map(emp -> emp.getSkills().toString()).distinct().toList();

        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }

    @GetMapping("/teams")
    @Operation(summary = "Get Teams")
    public ResponseEntity<List<String>> getTeams() {
        List<Employee> employees = employeeRepo.findAll();
        List<String> teams = employees.stream()
        .map(team -> team.getTeam().toUpperCase()).distinct().toList();

        return ResponseEntity.status(HttpStatus.OK).body(teams);
    }

}
