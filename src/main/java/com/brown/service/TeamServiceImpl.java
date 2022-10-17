package com.brown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brown.model.Team;
import com.brown.repository.TeamRepository;

public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamRepository teamRepository;

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

}
