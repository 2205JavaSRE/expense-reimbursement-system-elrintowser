package com.revature.controller;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {

	private UserService us = new UserServiceImpl();
	
	public void login(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		if (us.authenticate(u.getUsername(), u.getPassword())) {
			ctx.sessionAttribute("user", u);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(401);
		}
		
	}

	public void getSessionUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		u.setPassword(null);
		ctx.json(u);		
	}

	public void updatePassword(Context ctx) {
		if(ctx.sessionAttribute("user") != null) {
			us.updatePassword(ctx.sessionAttribute("user"), ctx.formParam("password"));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
		
	}

	public void updateUserType(Context ctx) {
		if(ctx.sessionAttribute("user") != null) {
			us.updatePassword(ctx.sessionAttribute("user"), ctx.formParam("userType"));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	}

	public void createUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("Finance Manager")) {
				us.addUser(ctx.bodyAsClass(User.class));
				ctx.status(200);
			} else {
				ctx.status(401);
			}
		}else {
			ctx.status(401);
		}
		
	}

	
}
