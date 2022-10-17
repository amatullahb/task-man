package com.brown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brown.model.User;
import com.brown.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);	
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public void updateUserName(Long id, String firstname, String lastname) {
		Optional<User> _user = userRepository.findById(id);
		User user = _user.get();
		user.setFirstname(firstname);
		user.setLastname(lastname);
	}

	@Override
	public void updateUserEmail(Long id, String email) {
		Optional<User> _user = userRepository.findById(id);
		User user = _user.get();
		user.setEmail(email);
	}

	@Override
	public void updateUserPassword(Long id, String password) {
		Optional<User> _user = userRepository.findById(id);
		User user = _user.get();
		user.setPassword(password);
		
	}

}
