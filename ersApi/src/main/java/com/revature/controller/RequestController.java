package com.revature.controller;

import com.revature.models.User;

import io.javalin.Javalin;

public class RequestController {
	
	private UserController userController = new UserController();
	private TicketController ticketController = new TicketController();
	
	public RequestController() {
		super();
	}
	
	public void configureRoutes(Javalin app) {
		app.post("/get/session", ctx -> {
			User u = ctx.bodyAsClass(User.class);
			ctx.sessionAttribute("user",u);
		});
		
		app.get("/session/user", ctx ->{
			User u = ctx.sessionAttribute("user");
		});
		
		app.get("/session/invalidate", ctx ->{
			ctx.consumeSessionAttribute("user");
		});
		
		app.post("/user/{password}", ctx ->{
			//update user password
		});
		
		app.post("/user/{userType}", ctx -> {
			//update userType
		});
		
		app.get("/ticket/{ticketId}", ctx ->{
			//get ticket by ID
		});
		
		app.get("/tickets", ctx -> {
			//get all tickets
		});
		
		app.get("/tickets/past", ctx -> {
			//get all past tickets
		});
		
		app.post("/user", ctx -> {
			//create user
		});
		
		app.post("/user/ticket", ctx -> {
			//create ticket
		});
		
		app.get("/tickets", ctx -> {
			//get all tickets 
		});
		
		app.get("/user/tickets", ctx ->{
			//get all user tickets
		});
		
		app.get("/user/pasttickets", ctx -> {
			//get all user past tickets
		});
	}
	
	

}
