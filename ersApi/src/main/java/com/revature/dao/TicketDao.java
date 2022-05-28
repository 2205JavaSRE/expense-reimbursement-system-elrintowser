package com.revature.dao;

import java.util.List;

import com.revature.exceptions.InavlidExpenseTypeException;
import com.revature.models.Ticket;

public interface TicketDao {

	Ticket selectTicketById(int id) throws InavlidExpenseTypeException;

	List<Ticket> selectAllTickets();

	List<Ticket> selectAllPastTickets();

	void insertTicket(Ticket t);

	List<Ticket> selectTicketsByUser();

	List<Ticket> selectPastTicketsByUser();

}
