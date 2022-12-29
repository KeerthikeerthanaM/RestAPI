package com.example.demoWebApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoWebApp.model.User;

public interface UserRepository extends  JpaRepository<User, Integer> {

}
