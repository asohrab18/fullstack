package com.foods.meerut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String getAccountDetails() {
		return "Welcome to Fullstack world!";
	}

}
