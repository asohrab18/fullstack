package com.foods.meerut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.meerut.entity.User;
import com.foods.meerut.exception.RecipeException;
import com.foods.meerut.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

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
	public List<User> findAllUsers() {
		List<User> users = userRepo.findAll();
		if (users == null || users.isEmpty()) {
			throw new RecipeException("Users do not exist.");
		}
		return userRepo.findAll();
	}

	@Override
	public User findByEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new RecipeException("Email is required");
		}
		User existingUser = userRepo.findByEmail(email.trim());
		if (existingUser == null) {
			throw new RecipeException("User does not exist with email: '" + email + "'");
		}
		return existingUser;
	}

	@Override
	public String deleteUser(Long id) {
		if (id == null || id <= 0) {
			throw new RecipeException("Valid id is required.");
		}
		boolean userExists = userRepo.existsById(id);
		if (!userExists) {
			return "user does not exist with id = " + id;
		}
		userRepo.deleteById(id);
		return "user deleted successfully with id = " + id;
	}
}
