package com.chetan.springboot.springstarter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chetan.springboot.springstarter.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

Optional<User> findByUserName(String userName);

}
