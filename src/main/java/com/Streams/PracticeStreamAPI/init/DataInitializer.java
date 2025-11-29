package com.Streams.PracticeStreamAPI.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Streams.PracticeStreamAPI.repository.EmployeeRepo;
import com.Streams.PracticeStreamAPI.repository.UserRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(EmployeeRepo employeeRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
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

        UserInitializer.Initializer(userRepo, passwordEncoder);

        
    }

}
