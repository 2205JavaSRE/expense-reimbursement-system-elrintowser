package com.revature.services;

import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Ticket;
import com.revature.models.User;

public interface TicketService {

	Ticket getTicketById(int id, User u);
	Object getAllTickets();
	void addTicket(Ticket t, int uid) throws InvalidAmountException;
	Object getPendingTickets();
	Object getApprovedTickets();
	Object getDeclinedTickets();
	Object getPendingTickets(User u);
	Object getApprovedTickets(User u);
	Object getDeclinedTickets(User u);
	void approveTicket(Ticket t);
	void declineTicket(Ticket t);

}
