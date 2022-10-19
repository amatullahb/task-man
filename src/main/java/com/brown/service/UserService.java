package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.brown.dto.UserDto;
import com.brown.model.User;

public interface UserService {
	
	public User getUserById (Long id);
	
	public List<UserDto> getAllUsers ();
	
	public void addUser (User user);
	
	public void addUser (UserDto userDto);
	
	public void updateUserName (Long id, String firstname, String lastname);
	
	public void updateUserEmail (Long id, String email);
	
	public void updateUserPassword (Long id, String password);
	
	public void deleteUser (User user);
	
	public void deleteUserById (Long id);
	
//	@Query(value = "SELECT * FROM user where email = ?1", nativeQuery = true)
	public User findUserByEmail (String email);

}
