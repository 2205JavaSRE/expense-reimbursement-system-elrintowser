package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapper {
	
	private UserController userController = new UserController();
	private TicketController ticketController = new TicketController();
	
	public RequestMapper() {
		super();
	}
	
	public void configureRoutes(Javalin app) {
		app.post("/get/login", ctx -> userController.login(ctx));//
		
		app.get("/session/user", ctx -> userController.getSessionUser(ctx));//
		
		app.get("/session/invalidate", ctx -> ctx.consumeSessionAttribute("user"));//
		
		app.post("/user/updatePassword", ctx -> userController.updatePassword(ctx));//
		
		app.post("/user/updateType", ctx -> userController.updateUserType(ctx));//
		
		app.post("/user", ctx -> userController.createUser(ctx));//
		
		app.get("/ticket/id", ctx -> ticketController.getTicketById(ctx));//
		
		app.get("/tickets", ctx -> ticketController.getTickets(ctx));//
		
		app.get("/tickets/past", ctx -> ticketController.getPastTickets(ctx));//
		
		app.post("/user/ticket", ctx -> ticketController.createTicket(ctx));
		
		app.get("/user/tickets", ctx -> ticketController.getTicketsByUser(ctx));//
		
		app.get("/user/pasttickets", ctx -> ticketController.getPastTicketsByUser(ctx));//
	}
	
	

}
