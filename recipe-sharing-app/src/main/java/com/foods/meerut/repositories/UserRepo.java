package com.foods.meerut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foods.meerut.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
