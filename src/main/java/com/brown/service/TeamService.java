package com.brown.service;

import java.util.List;

import com.brown.model.Team;
import com.brown.model.User;

public interface TeamService {
	
	public List<Team> getAllTeams ();
	
	public Team getTeamById (Long id);
	
	public void addTeam (Team team);
	
	public void deleteTeam (Team team);
	
	public void deleteTeamById (Long id);
	
	public void updateTeam (Team team);
	
	public void updateTeamName (Long id, String name);
	
	public void updateTeamDescription (Long id, String description);
	
	public void addTeamMember (Long id, User member);
	
	public void removeTeamMember (Long id, User member);

}
