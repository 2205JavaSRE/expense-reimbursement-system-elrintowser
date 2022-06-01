package com.revature.controller;

import com.revature.monitor.Monitor;

import io.javalin.Javalin;

public class RequestMapper {
	
	private UserController userController = new UserController();
	private TicketController ticketController = new TicketController();
	
	public RequestMapper() {
		super();
	}
	
	public void configureRoutes(Javalin app, Monitor monitor) {
		app.post("/get/login", ctx -> {
			userController.login(ctx);
			monitor.loginCounter();
		});
		
		app.get("/session/user", ctx -> userController.getSessionUser(ctx));
		
		app.get("/session/invalidate", ctx -> ctx.consumeSessionAttribute("user"));
		
		app.post("/user/updatePassword", ctx -> userController.updatePassword(ctx));
		
		app.post("/user/updateType", ctx -> userController.updateUserType(ctx));
		
		app.post("/user", ctx -> userController.createUser(ctx));
		
		app.get("/ticket/id", ctx -> ticketController.getTicketById(ctx));
		
		app.get("/tickets", ctx -> ticketController.getTickets(ctx));
		
		app.get("/tickets/approved", ctx -> ticketController.getApprovedTickets(ctx));
		
		app.get("/tickets/pending", ctx -> ticketController.getPendingTickets(ctx));
		
		app.get("/tickets/declined", ctx -> ticketController.getDeclinedTickets(ctx));
		
		app.post("/user/ticket", ctx -> ticketController.createTicket(ctx));
		
		app.get("/user/pending", ctx -> ticketController.getPendingTicketsByUser(ctx));
		
		app.get("/user/approved", ctx -> ticketController.getApprovedTicketsByUser(ctx));
		
		app.get("/user/declined", ctx -> ticketController.getDeclinedTicketsByUser(ctx));
		
		app.post("/ticket/approve", ctx -> ticketController.approveTicket(ctx));
		
		app.post("/ticket/decline", ctx -> ticketController.declineTicket(ctx));
		
		app.get("/metrics", ctx -> ctx.result(Monitor.registry.scrape()));
	}
	
	

}
