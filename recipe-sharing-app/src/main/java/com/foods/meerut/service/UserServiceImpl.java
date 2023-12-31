package com.foods.meerut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.meerut.exception.RecipeException;
import com.foods.meerut.model.User;
import com.foods.meerut.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAllUsers() {
		List<User> users = userRepo.findAll();
		if (users == null || users.isEmpty()) {
			throw new RecipeException("Users do not exist.");
		}
		return userRepo.findAll();
	}

	@Override
	public User createUser(User user) {
		if (user.getEmail() == null || user.getEmail().isBlank()) {
			throw new RecipeException("Email is required");
		}
		User existingUser = userRepo.findByEmail(user.getEmail().trim());
		if (existingUser != null) {
			throw new RecipeException("'" + user.getEmail() + "' already exists. Use another email or sign in.");
		}
		return userRepo.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email.trim());
	}

	@Override
	public String deleteUser(Long id) {
		boolean userExists = userRepo.existsById(id);
		if (!userExists) {
			return "user with id = " + id + " does not exist.";
		}
		userRepo.deleteById(id);
		return "user with id = " + id + " deleted successfully.";
	}
}
