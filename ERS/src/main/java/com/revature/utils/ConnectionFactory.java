package com.revature.utils;

import java.sql.*;

public class ConnectionFactory {
	private static String URL = System.getenv("db_url");
	private static String USERNAME = System.getenv("db_username");
	private static String PASSWORD = System.getenv("db_password");
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

	private ConnectionFactory() {
		super();
	}
	
	
}
