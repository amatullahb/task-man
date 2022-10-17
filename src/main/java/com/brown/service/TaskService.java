package com.brown.service;

import java.util.List;

import com.brown.model.Task;
import com.brown.model.User;

public interface TaskService {
	
	public List<Task> getAllTasks ();
	
	public Task getTaskById (Long id);
	
	public void addTask (Task task);
	
	public void deleteTask (Task task);
	
	public void deleteTaskById (Long id);
	
	public void updateTaskDescription (Long id, String description);
	
	public void markTaskUrgent (Long id);
	
	public void markTaskNonUrgent (Long id);
	
	public void updateTaskStatus (Long id, String status);
	
	public void addUserToTask (Long id, User user);
	
	public void removeUserFromTask (Long id, User user);

}
