package com.revature.services;

import java.util.List;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.exceptions.InavlidExpenseTypeException;
import com.revature.models.Ticket;
import com.revature.models.User;

public class TicketServiceImpl implements TicketService {

	private TicketDao tDao = new TicketDaoImpl();
	
	@Override
	public Ticket getTicketById(int id, User u) {
		Ticket t;
		try {
			t = tDao.selectTicketById(id);
			System.out.println(t);
			if(u.getUserType().equals("finance manager")||u.getId() == t.getuId()) {
				return t;
			}else {
				return null;
			}
		} catch (InavlidExpenseTypeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return tDao.selectAllTickets();
		 
	}

	@Override
	public List<Ticket> getPastTickets() {
		return tDao.selectAllPastTickets();
	}

	@Override
	public void addTicket(Ticket t, int uid) {
		tDao.insertTicket(t, uid);
		
	}

	@Override
	public List<Ticket> getAllTickets(User u) {
		return tDao.selectTicketsByUser(u);
	}

	@Override
	public List<Ticket> getPastTickets(User u) {
		return tDao.selectPastTicketsByUser(u);
	}

}
