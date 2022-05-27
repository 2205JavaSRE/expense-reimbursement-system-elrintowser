package com.revature.dao;

import java.util.List;

import com.revature.exceptions.InvalidUserTypeException;
import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		super();
	}

	@Override
	public User selectUserByUsername(String username) {
		String sql = "SELECT * FROM login WHERE username = ?";
		Connection conn =ConnectionFactory.getConnection();
		User u = null;
		
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				u = new User(
						rs.getInt("id"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("user_type"));
			}
		} catch (SQLException|InvalidUserTypeException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public List<User> selectAllUsers() {
		String sql = "SELECT * FROM login";
		Connection conn =ConnectionFactory.getConnection();
		List<User> ul = new ArrayList<>();
		
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				ul.add(new User(
						rs.getInt("id"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("user_type")));
			}
		} catch (SQLException|InvalidUserTypeException e) {
			e.printStackTrace();
		}
		
		return ul;
	}

	@Override
	public void insertUser(User user) {
		String sql = "INSERT INTO login (username, password, user_type) "
				+ "VALUES (?, ?, ?)";
		Connection conn =ConnectionFactory.getConnection();

		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUserType());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePassword(User user, String password) {
		String sql = "UPDATE login SET password = ? WHERE username = ?";
		Connection conn = ConnectionFactory.getConnection();
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, password);
			ps.setString(2, user.getUsername());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUserType(User user, String userType) {
		String sql = "UPDATE login SET user_type = ? WHERE username = ?";
		Connection conn = ConnectionFactory.getConnection();
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, userType);
			ps.setString(2, user.getUsername());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
