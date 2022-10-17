package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.brown.model.Team;
import com.brown.model.User;
import com.brown.repository.TeamRepository;

public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamRepository teamRepository;

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getTeamById(Long id) {
		Optional<Team> _team = teamRepository.findById(id);
		return _team.get();
	}

	@Override
	public void addTeam(Team team) {
		teamRepository.save(team);		
	}

	@Override
	public void deleteTeam(Team team) {
		teamRepository.delete(team);
	}

	@Override
	public void deleteTaskById(Long id) {
		teamRepository.deleteById(id);
	}

	@Override
	public void updateTeamName(Long id, String name) {
		Optional<Team> _team = teamRepository.findById(id);
		Team team = _team.get();
		team.setName(name);
	}

	@Override
	public void updateTeamDescription(Long id, String description) {
		Optional<Team> _team = teamRepository.findById(id);
		Team team = _team.get();
		team.setDescription(description);
	}

	@Override
	public void addTeamMember(Long id, User member) {
		Optional<Team> _team = teamRepository.findById(id);
		Team team = _team.get();
		team.addMember(member);
	}

	@Override
	public void removeTeamMember(Long id, User member) {
		Optional<Team> _team = teamRepository.findById(id);
		Team team = _team.get();
		team.removeMember(member);
	}

}
