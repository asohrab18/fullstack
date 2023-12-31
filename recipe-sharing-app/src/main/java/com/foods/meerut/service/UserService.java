package com.foods.meerut.service;

import java.util.List;

import com.foods.meerut.model.User;

public interface UserService {

	User createUser(User user);

	List<User> findAllUsers();

	User findByEmail(String email);

	String deleteUser(Long id);
}
