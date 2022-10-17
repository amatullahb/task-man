package com.brown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brown.model.Project;
import com.brown.repository.ProjectRepository;

public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

}
