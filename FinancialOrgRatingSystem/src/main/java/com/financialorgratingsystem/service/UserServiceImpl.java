package com.financialorgratingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.repository.UserRepo;
import com.financialorgratingsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public User addUser(User u) {
		User user = userRepo.save(u);
		return user;
	}

	@Override
	public String login(int userId, String userPassword) throws UserNotFoundException {

		if (userRepo.existsById(userId)) {
			String password = userRepo.getPassword(userId);
			if (password.equals(userPassword)) {

				User user = userRepo.getById(userId);

				if (user.getRole().equalsIgnoreCase("user")) {

					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Administrator")) {

					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Organization Rep")) {

					return user.getRole();

				}

			} } 
				throw new UserNotFoundException("Incorrect UserId or User Password");
			
	}

	@Override
	public User getUserById(Integer userId) throws UserNotFoundException {
		if (userRepo.existsById(userId)) {
			return userRepo.getById(userId);
		}
		throw new UserNotFoundException("Enter valid userId");
	}

	public List<User> viewUser() {

		return userRepo.findAll();
	}

}