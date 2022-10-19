package com.brown.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brown.dto.UserDto;
import com.brown.model.User;
import com.brown.repository.UserRepository;
import com.brown.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
     * Displays home page which prompts the user to login
     * @return index.html
     */
    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("user", new UserDto());
        return "index";
    }
    
    @PostMapping("/register")
    public String register (@Valid @ModelAttribute("user") UserDto userDto,
                                BindingResult result,
                                Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered to this email");
        }
        
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/";
        }
        
        userService.addUser(userDto);
        
        return "/users";
    }
    
    @GetMapping("/login")
    public String showLogin () {
        return "login";
    }
    
   
    
    @GetMapping("/project")
    public String showProject () {
        return "project";
    }
    

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
		model.addAttribute("usersList", userService.getAllUsers());
		return "users";
	}
	
	@PostMapping("/users")
    public String viewAllUsers (Model model) {
	    model.addAttribute("usersList", userService.getAllUsers());
        return "users";
    }
    
	

//    @GetMapping("/error")
//    public String showError () {
//        return "error";
//    }
	
}
