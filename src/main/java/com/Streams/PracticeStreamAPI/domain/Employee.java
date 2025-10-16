package com.Streams.PracticeStreamAPI.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EmployeeInfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employeeId;
    private String name;
    private String department;
    private double salary;
    private Date dob;
    private Date joiningDate;
    private int age;
    private String city;
    private String gender;
    @Column(name = "experience")
    private int yearsOfExperience;
    private String jobTitle;
    @Column(name = "Edu_Level")
    private String educationLevel;
    private boolean isFullTime;
    private boolean isMarried;
    private String phoneNumber;
    private String email;
    private String address;
    private String country;
    private String state;
    private boolean isActive;
    private String managerName;
    private String companyName;
    private String skills;
    private String projectName;
    @Column(name = "Perf_Rating")
    private int performanceRating;
    private double bonus;
    private String workLocation;
    private String employmentType;
    private String shift;
    private String team;

}
