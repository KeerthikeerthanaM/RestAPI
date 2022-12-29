package com.example.demoWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWebApp.model.User;
import com.example.demoWebApp.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// save users
	public void saveUser(User user) {
		userRepository.save(user);

	}

	// to view all users
	public List<User> listAllUser() {
		return userRepository.findAll();
	}

	// to view particular user
	public User getUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public User updateUser(User user, Integer id) {
		User existingUser = userRepository.findById(id).orElseThrow(); // we need to check if a given id is existing in
																		// db or not
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		userRepository.save(existingUser); // to save new details in db
		return existingUser;
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

}
