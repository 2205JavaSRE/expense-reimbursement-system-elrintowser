package com.revature.dao;

import java.util.List;

import com.revature.models.Ticket;

public interface TicketDao {

	Ticket selectTicketById(int id);

	List<Ticket> selectAllTickets();

	List<Ticket> selectAllPastTickets();

	void insertTicket();

	List<Ticket> selectTicketsByUser();

	List<Ticket> selectPastTicketsByUser();

}
