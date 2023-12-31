package com.foods.meerut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foods.meerut.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
