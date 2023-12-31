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

import com.foods.meerut.model.User;
import com.foods.meerut.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("users")
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}

	@GetMapping("users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("users-by-email")
	public User findUserByEmail(@RequestParam(required = true) String email) throws Exception {
		return userService.findByEmail(email);
	}

	@DeleteMapping("users/{id}")
	public String deleteUser(@PathVariable Long id) throws Exception {
		return userService.deleteUser(id);
	}
}
