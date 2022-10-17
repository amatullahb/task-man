package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.brown.model.Task;
import com.brown.model.User;
import com.brown.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		Optional<Task> _task = taskRepository.findById(id);
		return _task.get();
	}

	@Override
	public void addTask(Task task) {
		taskRepository.save(task);		
	}

	@Override
	public void deleteTask(Task task) {
		taskRepository.delete(task);
		
	}

	@Override
	public void deleteTaskById(Long id) {
		taskRepository.deleteById(id);
		
	}

	@Override
	public void updateTaskDescription(Long id, String description) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.setDescription(description);
	}

	@Override
	public void markTaskUrgent(Long id) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.setUrgent(true);
	}

	@Override
	public void markTaskNonUrgent(Long id) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.setUrgent(false);
		
	}

	@Override
	public void updateTaskStatus(Long id, String status) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.setStatus(status);
	}

	@Override
	public void addUserToTask(Long id, User user) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.assignToUser(user);
	}

	@Override
	public void removeUserFromTask(Long id, User user) {
		Optional<Task> _task = taskRepository.findById(id);
		Task task = _task.get();
		task.removeUserFromTask(user);
	}

}
