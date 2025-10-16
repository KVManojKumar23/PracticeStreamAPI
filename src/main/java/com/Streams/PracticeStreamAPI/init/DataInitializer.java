package com.Streams.PracticeStreamAPI.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Streams.PracticeStreamAPI.repository.EmployeeRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;

    public DataInitializer(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // Check if the repo is empty before calling initializer
        if (employeeRepo.count() == 0) {
            EmployeeInitializer.Initializer(employeeRepo);
            System.out.println("Employees loaded successfully.");
        } else {
            System.out.println("Employees already exist. Skipping initialization.");
        }
    }

}
