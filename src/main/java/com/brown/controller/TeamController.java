package com.brown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.brown.model.Team;
import com.brown.service.TaskService;
import com.brown.service.TeamService;
import com.brown.service.UserService;
import com.brown.userstore.ActiveUserStore;

@Controller
public class TeamController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TeamService teamService;
    
    @Autowired
    private ActiveUserStore loggedUser;
    
    /**
     * Shows all teams
     * @param model
     * @return teams.html
     */
    @GetMapping("/teams")
    public String getTeams (Model model) {
        model.addAttribute("teamList", teamService.getAllTeams());
        Team team = new Team();
        model.addAttribute("team", team);
        model.addAttribute("user", loggedUser.getUser());
        return "teams";
    }
    
    /**
     * Is called when a new team is added via frontend
     * @param team
     * @param model
     * @return teams.html with new team
     */
    @PostMapping("/teams")
    public String postTeams (@ModelAttribute("team") Team team, Model model) {
        Team newTeam = new Team();
        newTeam.setName(team.getName());
        newTeam.setDescription(team.getDescription());
        teamService.addTeam(newTeam);
        model.addAttribute("teamList", teamService.getAllTeams());
        return "teams";
    }
    
    @DeleteMapping("/teams/{id}")
    public String deleteTeam (@PathVariable(value="id") Long id) {
        teamService.deleteTeamById(id);
        return "redirect:/teams";
    }
    
    @GetMapping("/teams/{id}")
    public String getTeam (Model model, @PathVariable(value="id") Long id) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        return "team";
    }
    
    @PostMapping("/teams/{id}")
    public String postTeam (Model model, @PathVariable(value="id") Long id) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        return "redirect:/teams/" + id;
    }
    
    @PutMapping("teams/{id}")
    public String putTeam (Model model, @PathVariable(value="id") Long id, 
                            @ModelAttribute("team") Team teamData) {
//        Team team = teamService.getTeamById(id);
//        if (teamData.getName() != null) {
//            teamService.updateTeamName(id, teamData.getName());
//        }
//        
//        if (teamData.getDescription() != null) {
//            teamService.updateTeamDescription(id, teamData.getDescription());
//        }
        teamService.updateTeam(teamData);
        return "redirect:/teams/" + id;
    }

}
