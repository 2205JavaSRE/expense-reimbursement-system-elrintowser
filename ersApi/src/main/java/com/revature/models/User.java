package com.revature.models;

import java.util.Objects;

import com.revature.exceptions.InvalidUserTypeException;

public class User {

	private int id;
	private String username;
	private String password;
	private String userType;
	
	public User() {
		super();
	}
	
	

	public User(int id, String username, String password, String userType) throws InvalidUserTypeException {
		super();
		if (userType.equals("employee")||userType.equals("finance manager")) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.userType = userType;
		} else {
			throw new InvalidUserTypeException();
		}
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUseType(String userType) throws InvalidUserTypeException {
		if(userType.equals("employee")||userType.equals("finance manager")) {
			this.userType = userType;
		} else {
			throw new InvalidUserTypeException();
		}
	}



	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", user_type=" + userType
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, password, userType, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(userType, other.userType)
				&& Objects.equals(username, other.username);
	}

	
}
