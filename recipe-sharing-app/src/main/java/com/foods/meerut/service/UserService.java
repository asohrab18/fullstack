package com.foods.meerut.service;

import java.util.List;

import com.foods.meerut.model.User;

public interface UserService {

	User createUser(User user);

	User findByEmail(String email);

	List<User> findAllUsers();

	String deleteUser(Long id);
}
