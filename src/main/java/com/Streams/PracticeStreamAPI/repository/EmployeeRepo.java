package com.Streams.PracticeStreamAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Streams.PracticeStreamAPI.domain.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
