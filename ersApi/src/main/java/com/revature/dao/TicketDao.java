package com.revature.dao;

import java.util.List;

import com.revature.exceptions.InavlidExpenseTypeException;
import com.revature.models.Ticket;
import com.revature.models.User;

public interface TicketDao {

	Ticket selectTicketById(int id) throws InavlidExpenseTypeException;

	List<Ticket> selectAllTickets();

	List<Ticket> selectAllPastTickets();

	void insertTicket(Ticket t, int uid);

	List<Ticket> selectTicketsByUser(User u);

	List<Ticket> selectPastTicketsByUser(User u);

}
