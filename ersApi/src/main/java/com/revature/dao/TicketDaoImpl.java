package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.*;
import com.revature.models.Ticket;
import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

public class TicketDaoImpl implements TicketDao {

	@Override
	public Ticket selectTicketById(int id)  {
		String sql = "SELECT * FROM ticket WHERE id = ?";
		Connection conn =ConnectionFactory.getConnection();
		Ticket t = null;
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				t = new Ticket(
						rs.getInt("id"), 
						rs.getDouble("amt"),
						rs.getString("expense_type"),
						rs.getInt("l_id"),
						rs.getString("status"));
			}
		} catch (SQLException|InavlidExpenseTypeException|InvalidStatusException e) {
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public List<Ticket> selectAllTickets() {
		List<Ticket> ticketList = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket";
		Connection conn =ConnectionFactory.getConnection();
		Ticket t = null;
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				t = new Ticket(
						rs.getInt("id"), 
						rs.getDouble("amt"),
						rs.getString("expense_type"),
						rs.getInt("l_id"),
						rs.getString("status"));
				ticketList.add(t);
			}
		} catch (SQLException|InavlidExpenseTypeException|InvalidStatusException e) {
			e.printStackTrace();
		}
		
		return ticketList;
	}

	@Override
	public List<Ticket> selectAllPastTickets() {
		// TODO Auto-generated method stub
		List<Ticket> ticketList = new ArrayList<>();
		try {
			ticketList.add(new Ticket(0, 35.86, "food", 4, "pending"));
		} catch (InavlidExpenseTypeException | InvalidStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void insertTicket(Ticket t) {
		// TODO Auto-generated method stub
		System.out.println("ticket added" + t);
	}

	@Override
	public List<Ticket> selectTicketsByUser() {
		// TODO Auto-generated method stub
		List<Ticket> ticketList = new ArrayList<>();
		try {
			ticketList.add(new Ticket(0, 35.86, "food", 4, "pending"));
		} catch (InavlidExpenseTypeException | InvalidStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<Ticket> selectPastTicketsByUser() {
		// TODO Auto-generated method stub
		List<Ticket> ticketList = new ArrayList<>();
		try {
			ticketList.add(new Ticket(0, 35.86, "food", 4, "pending"));
		} catch (InavlidExpenseTypeException | InvalidStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}

}
