package com.revature.services;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.InvalidUserTypeException;
import com.revature.models.User;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		super();
	}

	@Override
	public boolean authenticate(String username, String password) {
		return password.equals(new UserDaoImpl().selectUserByUsername(username).getPassword());
				
	}

	@Override
	public User getUserByUsername(String username) {
		return new UserDaoImpl().selectUserByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return new UserDaoImpl().selectAllUsers();
	}

	@Override
	public void addUser(User user) {
		new UserDaoImpl().insertUser(user);

	}

	@Override
	public void updatePassword(User user, String password) {
		new UserDaoImpl().updatePassword(user, password);

	}

	@Override
	public void updateUserType(User user, String userType) throws InvalidUserTypeException {
		if(userType.equals("employee")||userType.equals("finance manager")) {
			new UserDaoImpl().updateUserType(user, userType);
		} else {
			throw new InvalidUserTypeException();
		}
	}

}
