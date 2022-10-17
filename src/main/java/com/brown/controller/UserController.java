package com.brown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brown.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * Display user's profile
	 * @param model
	 * @return user.html
	 */
	@GetMapping("/users/{id}")
	public String viewUser (@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}
	
	/**
	 * Display all users
	 * @param model
	 * @return users.html
	 */
	@GetMapping("/users")
	public String viewUsers (Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
}
