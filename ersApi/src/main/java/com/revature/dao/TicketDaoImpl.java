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
		List<Ticket> ticketList = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket WHERE status = 'approved' OR status = 'declined'";
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
	public void insertTicket(Ticket t, int uid) {
		String sql = "INSERT INTO ticket (amt, expense_type, l_id, status) "
				+ "VALUES (?, ?, ?, ?)";
		Connection conn =ConnectionFactory.getConnection();

		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setDouble(1, t.getAmt());
			ps.setString(2, t.getExpenseType());
			ps.setInt(3, uid);
			ps.setString(4, "pending");
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Ticket> selectTicketsByUser(User u) {
List<Ticket> ticketList = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket WHERE l_id = ?";
		Connection conn =ConnectionFactory.getConnection();
		Ticket t = null;
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, u.getId());
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
	public List<Ticket> selectPastTicketsByUser(User u) {
List<Ticket> ticketList = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket WHERE (status = 'approved' OR status = 'declined') AND l_id = ?";
		Connection conn =ConnectionFactory.getConnection();
		Ticket t = null;
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, u.getId());
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

}
