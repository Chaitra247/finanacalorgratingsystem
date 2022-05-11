package com.financialorgratingsystem.service;

import java.util.List;
import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;

public interface UserService {
	public User addUser(User u);

	public String login(int userId, String password) throws UserNotFoundException;

	public User getUserById(Integer userId) throws UserNotFoundException;

	public List<User> viewUser();

	
}
