package com.revature.services;

import java.util.List;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.exceptions.InavlidExpenseTypeException;
import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Ticket;
import com.revature.models.User;

public class TicketServiceImpl implements TicketService {

	private TicketDao tDao = new TicketDaoImpl();
	
	@Override
	public Ticket getTicketById(int id, User u) {
		Ticket t;
		try {
			t = tDao.selectTicketById(id);
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
	public void addTicket(Ticket t, int uid) throws InvalidAmountException {
		if(t.getAmt()>0) {
			tDao.insertTicket(t, uid);
		} else {
			throw new InvalidAmountException();
		}
	}

	@Override
	public List<Ticket> getPendingTickets(User u) {
		return tDao.selectPendingTicketsByUser(u);
	}

	@Override
	public List<Ticket> getApprovedTickets(User u) {
		return tDao.selectApprovedTicketsByUser(u);
	}

	@Override
	public void approveTicket(Ticket t) {
		tDao.approveTicket(t);
	}

	@Override
	public void declineTicket(Ticket t) {
		tDao.declineTicket(t);
	}

	@Override
	public List<Ticket> getDeclinedTickets(User u) {
		return tDao.selectDeclinedTicketsByUser(u);
	}


	@Override
	public List<Ticket> getPendingTickets() {
		return tDao.selectPendingTickets();
	}

	@Override
	public List<Ticket> getApprovedTickets() {
		return tDao.selectApprovedTickets();
	}

	@Override
	public List<Ticket> getDeclinedTickets() {
		return tDao.selectDeclinedTickets();
	}

}
