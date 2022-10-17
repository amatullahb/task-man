package com.brown.service;

import java.util.List;
import java.util.Optional;

import com.brown.model.User;

public interface UserService {
	
	public Optional<User> getUserById (Long id);
	
	public List<User> getAllUsers ();
	
	public void addUser (User user);
	
	public void updateUserName (Long id, String firstname, String lastname);
	
	public void updateUserEmail (Long id, String email);
	
	public void updateUserPassword (Long id, String password);
	
	public void deleteUser (User user);
	
	public void deleteUserById (Long id);

}
