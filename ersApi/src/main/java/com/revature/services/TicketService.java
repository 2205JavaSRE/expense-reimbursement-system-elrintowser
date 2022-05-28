package com.revature.services;

import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Ticket;
import com.revature.models.User;

public interface TicketService {

	Ticket getTicketById(int id, User u);
	Object getAllTickets();
	Object getPastTickets();
	void addTicket(Ticket t, int uid) throws InvalidAmountException;
	Object getAllTickets(User u);
	Object getPastTickets(User u);
	void approveTicket(Ticket t);
	void declineTicket(Ticket t);

}
