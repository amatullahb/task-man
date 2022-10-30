package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brown.model.Team;
import com.brown.model.User;
import com.brown.repository.TeamRepository;

@Service
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
		if (_team.isPresent()) {
		    return _team.get();
		} else {
		    return null;
		}
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
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);
	}

	@Override
	public void updateTeamName(Long id, String name) {
		Optional<Team> _team = teamRepository.findById(id);
		if (_team.isPresent()) {
		    Team team = _team.get();
		    team.setName(name);
		}
	}

	@Override
	public void updateTeamDescription(Long id, String description) {
		Optional<Team> _team = teamRepository.findById(id);
		if (_team.isPresent()) {
		    Team team = _team.get();
		    team.setDescription(description);
		}
	}

	@Override
	public void addTeamMember(Long id, User member) {
		Optional<Team> _team = teamRepository.findById(id);
		if (_team.isPresent()) {
		    Team team = _team.get();
		    team.addMember(member);
		}
	}

	@Override
	public void removeTeamMember(Long id, User member) {
		Optional<Team> _team = teamRepository.findById(id);
		if (_team.isPresent()) {
		    Team team = _team.get();
		    team.removeMember(member);
		}
	}

    @Override
    public void updateTeam(Team team) {
        Optional<Team> _team = teamRepository.findById(team.getId());
        if (_team.isPresent()) {
            Team updatedTeam = _team.get();
            if (team.getDescription() != null) {
                updatedTeam.setDescription(team.getDescription());
            }
            if (team.getName() != null) {
                updatedTeam.setName(team.getName());
            }
        }
        
    }

}
