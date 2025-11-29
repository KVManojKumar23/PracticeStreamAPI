package com.Streams.PracticeStreamAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Streams.PracticeStreamAPI.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

}
