package com.revature.dao;

import java.util.List;

import com.revature.exceptions.InavlidExpenseTypeException;
import com.revature.models.Ticket;
import com.revature.models.User;

public interface TicketDao {

	Ticket selectTicketById(int id) throws InavlidExpenseTypeException;

	List<Ticket> selectAllTickets();
	
	List<Ticket> selectPendingTickets();

	List<Ticket> selectApprovedTickets();
	
	List<Ticket> selectDeclinedTickets();

	void insertTicket(Ticket t, int uid);

	List<Ticket> selectPendingTicketsByUser(User u);

	List<Ticket> selectApprovedTicketsByUser(User u);
	
	List<Ticket> selectDeclinedTicketsByUser(User u);

	void approveTicket(Ticket t);

	void declineTicket(Ticket t);

}
