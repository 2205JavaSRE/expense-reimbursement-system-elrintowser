package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public User selectUserByUsername(String username);
	public List<User> selectAllUsers();
	public void insertUser(User user);
	public void updatePassword(User user, String password);
	public void updateUserType(User user, String userType);
}
