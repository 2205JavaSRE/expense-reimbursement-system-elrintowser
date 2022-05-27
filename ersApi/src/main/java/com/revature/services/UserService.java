package com.revature.services;

import java.util.List;

import com.revature.exceptions.InvalidUserTypeException;
import com.revature.models.User;

public interface UserService {
	public boolean authenticate(String username, String password);
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public void addUser(User user);
	public void updatePassword(User user, String password);
	public void updateUserType(User user, String userType) throws InvalidUserTypeException;
}
