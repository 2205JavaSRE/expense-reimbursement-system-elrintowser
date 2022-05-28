package com.revature.services;

import com.revature.models.Ticket;
import com.revature.models.User;

public interface TicketService {

	Ticket getTicketById(int id, User u);
	Object getAllTickets();
	Object getPastTickets();
	void addTicket(Ticket t, int uid);
	Object getAllTickets(User u);
	Object getPastTickets(User u);

}
