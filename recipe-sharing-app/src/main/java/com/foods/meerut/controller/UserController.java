package com.foods.meerut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foods.meerut.exception.RecipeException;
import com.foods.meerut.model.User;
import com.foods.meerut.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping("users")
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}


	@GetMapping("users-by-email")
	public User findUserByEmail(@RequestParam(required = true) String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new RecipeException("Email is required");
		}
		User existingUser = userService.findByEmail(email.trim());
		if (existingUser == null) {
			throw new RecipeException("User does not exist with email: '" + email + "'");
		}
		return existingUser;
	}

	@DeleteMapping("users/{id}")
	public String deleteUser(@PathVariable Long id) throws Exception {
		if (id == null || id <= 0) {
			throw new RecipeException("Valid id is required.");
		}
		return userService.deleteUser(id);
	}

}
