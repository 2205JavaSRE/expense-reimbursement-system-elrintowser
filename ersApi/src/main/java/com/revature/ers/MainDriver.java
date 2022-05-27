package com.revature.ers;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.InvalidUserTypeException;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class MainDriver {
	
	public static void main(String...args) {
		try {
			User u = new User(0, "test2", "password", "finance manager");
			
		} catch (InvalidUserTypeException e) {
			e.printStackTrace();
		}
		
		
	}
}
