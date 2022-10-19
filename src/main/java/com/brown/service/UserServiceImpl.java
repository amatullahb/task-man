package com.brown.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brown.dto.UserDto;
import com.brown.model.User;
import com.brown.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUserById(Long id) {
		Optional<User> _user = userRepository.findById(id);
		if (_user.isPresent()) {
		    return _user.get();
		} else {
		    return null; // best practice?
		}
	}
	
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream()
		            .map((user) -> mapToUserDto(user))
		            .collect(Collectors.toList());
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
    public void addUser(UserDto userDto) {
	    User user = new User();
	    user.setFirstname(userDto.getFirstname());
	    user.setLastname(userDto.getLastname());
	    user.setEmail(userDto.getEmail());
	    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);      
    }

	@Override
	public void updateUserName(Long id, String firstname, String lastname) {
		Optional<User> _user = userRepository.findById(id);
		if (_user.isPresent()) {
		    User user = _user.get();
		    user.setFirstname(firstname);
		    user.setLastname(lastname);
		}
	}

	@Override
	public void updateUserEmail(Long id, String email) {
		Optional<User> _user = userRepository.findById(id);
		if (_user.isPresent()) {
		    User user = _user.get();
		    user.setEmail(email);
		}
	}

	@Override
	public void updateUserPassword(Long id, String password) {
		Optional<User> _user = userRepository.findById(id);
		if (_user.isPresent()) {
		    User user = _user.get();
		    user.setPassword(password);
		}
		
	}

	@Override
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}
	
	private UserDto mapToUserDto (User user) {
	    UserDto userDto = new UserDto();
	    userDto.setFirstname(user.getFirstname());
	    userDto.setLastname(user.getLastname());
	    userDto.setEmail(user.getEmail());
	    return userDto;
	}

}
