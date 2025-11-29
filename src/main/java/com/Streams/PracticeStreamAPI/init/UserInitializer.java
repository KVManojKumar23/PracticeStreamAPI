package com.Streams.PracticeStreamAPI.init;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.Streams.PracticeStreamAPI.domain.User;
import com.Streams.PracticeStreamAPI.domain.enums.Gender;
import com.Streams.PracticeStreamAPI.domain.enums.Role;
import com.Streams.PracticeStreamAPI.domain.enums.Status;
import com.Streams.PracticeStreamAPI.repository.UserRepo;

public class UserInitializer {

    public static void Initializer(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        if (!userRepo.existsByUserName("admin")) {
            User user = new User();
            user.setName("Admin");
            user.setUserName("admin");
            user.setRole(Role.ADMIN);
            user.setStatus(Status.ACTIVE);
            user.setGender(Gender.OTHER);
            user.setPassword(passwordEncoder.encode("123"));

            userRepo.save(user);
            System.out.println("Admin user created successfully!");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

}
