package com.revature.controller;

import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Ticket;
import com.revature.models.User;
import com.revature.services.TicketService;
import com.revature.services.TicketServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.http.Context;

public class TicketController {
	
	private TicketService ts = new TicketServiceImpl();
	private UserService us = new UserServiceImpl();
	
	public void getTicketById(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			Ticket t = ts.getTicketById(ctx.bodyAsClass(Ticket.class).getId(), u);
			
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

	public void getApprovedTickets(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manager")) {
				ctx.json(ts.getApprovedTickets());
				ctx.status(200);
			} else {
				ctx.status(401);
			}
		}else {
			ctx.status(401);
		}
	}

	public void getPendingTickets(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manager")) {
				ctx.json(ts.getPendingTickets());
				ctx.status(200);
			} else {
				ctx.status(401);
			}
		}else {
			ctx.status(401);
		}
	}
	
	public void getDeclinedTickets(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manager")) {
				ctx.json(ts.getDeclinedTickets());
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
			try {
				ts.addTicket(ctx.bodyAsClass(Ticket.class), u.getId());
				ctx.status(201);
			} catch (InvalidAmountException e) {
				ctx.status(400);
			}
			
		} else {
			ctx.status(401);
		}
	}

	public void getPendingTicketsByUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		
		if(u!=null) {
			if (u.getUserType().equals("finance manage")) {
				User targetUser = ctx.bodyAsClass(User.class);
				targetUser = us.getUserByUsername(targetUser.getUsername());
				ctx.json(ts.getPendingTickets(targetUser));
				ctx.status(200);
			} else {
				ctx.json(ts.getPendingTickets(u));
				ctx.status(200);
			}
		} else {
			ctx.status(401);
		}
	}

	public void getApprovedTicketsByUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manage")) {
				User targetUser = ctx.bodyAsClass(User.class);
				targetUser = us.getUserByUsername(targetUser.getUsername());
				ctx.json(ts.getApprovedTickets(targetUser));
				ctx.status(200);
			} else {
				ctx.json(ts.getApprovedTickets(u));
				ctx.status(200);
			}
		} else {
			ctx.status(401);
		}
	}
	
	public void getDeclinedTicketsByUser(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null) {
			if (u.getUserType().equals("finance manage")) {
				User targetUser = ctx.bodyAsClass(User.class);
				targetUser = us.getUserByUsername(targetUser.getUsername());
				ctx.json(ts.getDeclinedTickets(targetUser));
				ctx.status(200);
			} else {
				ctx.json(ts.getDeclinedTickets(u));
				ctx.status(200);
			}
		} else {
			ctx.status(401);
		}
	}


	public void approveTicket(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null && u.getUserType().equals("finance manager")) {
			ts.approveTicket(ctx.bodyAsClass(Ticket.class));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	}

	public void declineTicket(Context ctx) {
		User u = ctx.sessionAttribute("user");
		if(u!=null && u.getUserType().equals("finance manager")) {
			ts.declineTicket(ctx.bodyAsClass(Ticket.class));
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	}

	

}
