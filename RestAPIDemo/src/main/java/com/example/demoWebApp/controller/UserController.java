package com.example.demoWebApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoWebApp.model.User;
import com.example.demoWebApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add") // to create new data
	public ResponseEntity<String> add(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<>("User details inserted successfully!...",HttpStatus.OK);

	}

	@GetMapping("") // to see all list
	public List<User> list() {
		return userService.listAllUser();
	}

	@GetMapping("{id}") // to see particular id
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}

	@PutMapping("/{id}") // to update data
	public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody User user) {

		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}") // to delete id
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully!............",HttpStatus.OK);
	}
}
