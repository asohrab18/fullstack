package com.foods.meerut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.meerut.model.User;
import com.foods.meerut.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
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

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

}
