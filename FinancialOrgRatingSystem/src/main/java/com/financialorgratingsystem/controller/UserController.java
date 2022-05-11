package com.financialorgratingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		User user1 = userService.addUser(user);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@GetMapping("/login/{userId}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable("userId") int userId,
			@PathVariable("password") String password) {

		String user1 = userService.login(userId, password);

		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@GetMapping("get/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
		User user = userService.getUserById(userId);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/all")

	public List<User> viewUser() {
		return userService.viewUser();
	}

}