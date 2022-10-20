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
import com.brown.model.Team;
import com.brown.model.User;
import com.brown.service.TeamService;
import com.brown.service.UserService;
import com.brown.userstore.ActiveUserStore;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ActiveUserStore loggedUser;
	
	/**
     * Displays home page which prompts the user to login
     * @return index.html
     */
    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("user", new UserDto());
        return "index";
    }
    
    /**
     * Checks to see if user already exists, if so, produces error if not, adds to database
     * @param userDto
     * @param result
     * @param model
     * @return /users{id} if successful
     */
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
        loggedUser.setUser(userService.findUserByEmail(userDto.getEmail()));
        
//        return "/users/" + loggedUser.getUser().getId();
        return "user";
    }
    
    @GetMapping("/login")
    public String showLogin () {
        return "login";
    }

	/**
	 * Display user's profile
	 * @param model
	 * @return user.html
	 */
	@GetMapping("/users/{id}")
	public String viewUser (@PathVariable("id") Long id, Model model) {
	    User user = userService.getUserById(id);
	    loggedUser.setUser(user);
		model.addAttribute("user", user);
		return "user";
	}
	
	/**
	 * Display all users
	 * @param model
	 * @return users.html
	 */
	@GetMapping("/team")
	public String viewUsers (Model model) {
		model.addAttribute("usersList", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/teams")
	public String viewTeams (Model model) {
	    model.addAttribute("teamList", teamService.getAllTeams());
	    Team team = new Team();
	    model.addAttribute("team", team);
	    model.addAttribute("user", loggedUser.getUser());
	    return "teams";
	}
	
	@PostMapping("/teams")
    public String viewNewTeam (@ModelAttribute("team") Team team, Model model) {
	    Team newTeam = new Team();
	    newTeam.setName(team.getName());
	    newTeam.setDescription(team.getDescription());
	    teamService.addTeam(newTeam);
        model.addAttribute("teamList", teamService.getAllTeams());
        return "teams";
    }
	
    
    @GetMapping("/project")
    public String showProject () {
        return "project";
    }
    
    @PostMapping("/project")
    public String joinTeam (@ModelAttribute("team") Team team, @ModelAttribute("user") User user, Model model) {
        teamService.addTeamMember(team.getId(), user);
        return "project";
    }
	
	
//	@PostMapping("/users")
//    public String viewAllUsers (Model model) {
//	    model.addAttribute("usersList", userService.getAllUsers());
//        return "users";
//    }
    
	

//    @GetMapping("/error")
//    public String showError () {
//        return "error";
//    }
	
}
