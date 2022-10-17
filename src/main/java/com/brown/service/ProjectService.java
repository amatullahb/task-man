package com.brown.service;

import java.util.List;

import com.brown.model.Project;
import com.brown.model.Task;
import com.brown.model.Team;

public interface ProjectService {
	
	public List<Project> getAllProjects ();
	
	public Project getProjectById (Long id);
	
	public void createProject (Project project);
	
	public void deleteProject (Project project);
	
	public void deleteProjectById (Long id);
	
	public void updateProjectName (Long id, String name);
	
	public void updateProjectDescription (Long id, String description);
	
	public void addTaskToProject (Long id, Task task);
	
	public void removeTaskFromProject (Long id, Task task);
	
	public void assignTeamToProject (Long id, Team team);
	
	public void updateProjectStatus (Long id, String status);

}
