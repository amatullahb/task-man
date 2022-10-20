package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brown.model.Project;
import com.brown.model.Task;
import com.brown.model.Team;
import com.brown.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    return _project.get();
		} else {
		    return null;
		}
	}

	@Override
	public void createProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}

	@Override
	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void updateProjectName(Long id, String name) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.setName(name);
		}
	}

	@Override
	public void updateProjectDescription(Long id, String description) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.setDescription(description);
		}
	}

	@Override
	public void addTaskToProject(Long id, Task task) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.addTask(task);
		}
	}

	@Override
	public void removeTaskFromProject(Long id, Task task) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.removeTask(task);
		}
	}

	@Override
	public void assignTeamToProject(Long id, Team team) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.setTeam(team);
		}
	}

	@Override
	public void updateProjectStatus(Long id, String status) {
		Optional<Project> _project = projectRepository.findById(id);
		if (_project.isPresent()) {
		    Project project = _project.get();
		    project.setStatus(status);
		}
	}

}
