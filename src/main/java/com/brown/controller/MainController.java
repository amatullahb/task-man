package com.brown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	/**
	 * Displays home page which prompts the user to login
	 * @return index.html
	 */
	@GetMapping("/")
	public String home () {
		return "html/index";
	}
	
	@PostMapping("/register")
	public String register () {
		return "user";
	}
	
	@GetMapping("/login")
	public String showLogin () {
		return "html/login";
	}
	
	//login postmapping
	
	@GetMapping("/error")
	public String showError () {
		return "html/error";
	}

}
