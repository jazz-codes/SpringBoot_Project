package com.yasminedpc.springdemo.Repository;

import com.yasminedpc.springdemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}