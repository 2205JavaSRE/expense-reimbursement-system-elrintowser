package com.revature.controller;

import com.revature.models.Ticket;
import com.revature.models.User;
import com.revature.services.TicketService;
import com.revature.services.TicketServiceImpl;

import io.javalin.http.Context;

public class TicketController {
	
	private TicketService ts = new TicketServiceImpl();
	
	public void getTicketById(Context ctx) {
		User u = ctx.sessionAttribute("user");
		System.out.println("ticket controller");
		if(u!=null) {
			Ticket t = ts.getTicketById(Integer.parseInt(ctx.formParam("ticketID")), u);
			
			if (t != null) {
				ctx.json(t);
				ctx.status(200);
			} else {
				ctx.status(404);
			}
		} else {
			ctx.status(401);
		}
	}

	public void getTickets(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manager")) {
				ctx.json(ts.getAllTickets());
				ctx.status(200);
			} else {
				ctx.status(401);
			}
		}else {
			ctx.status(401);
		}
	}

	public void getPastTickets(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manager")) {
				ctx.json(ts.getPastTickets());
				ctx.status(200);
			} else {
				ctx.status(401);
			}
		}else {
			ctx.status(401);
		}
	}

	

	public void createTicket(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			ts.addTicket(ctx.bodyAsClass(Ticket.class), u.getId());
			ctx.status(201);
		} else {
			ctx.status(401);
		}
	}

	public void getTicketsByUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			ctx.json(ts.getAllTickets(u));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	}

	public void getPastTicketsByUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			ctx.json(ts.getPastTickets(u));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	}

}
