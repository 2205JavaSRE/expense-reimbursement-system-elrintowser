package com.revature.services;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.models.Ticket;
import com.revature.models.User;

public class TicketServiceImpl implements TicketService {

	private TicketDao tDao = new TicketDaoImpl();
	
	@Override
	public Ticket getTicketById(int id, User u) {
		Ticket t = tDao.selectTicketById(id);
		if(u.getUserType().equals("Finance Manager")||u.getId() == t.getuId()) {
			return t;
		}else {
			return null;
		}
	}

	@Override
	public Object getAllTickets() {
		return tDao.selectAllTickets();
		 
	}

	@Override
	public Object getPastTickets() {
		return tDao.selectAllPastTickets();
	}

	@Override
	public void addTicket(Ticket t) {
		tDao.insertTicket();
		
	}

	@Override
	public Object getAllTickets(User u) {
		return tDao.selectTicketsByUser();
	}

	@Override
	public Object getPastTickets(User u) {
		return tDao.selectPastTicketsByUser();
	}



}
