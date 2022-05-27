package com.revature.models;

import java.util.Objects;

import com.revature.exceptions.InavlidExpenseTypeException;

public class Ticket {
	private int id;
	private double amt;
	private String expenseType;
	private int uId;
	
	
	public Ticket() {
		super();
	}


	public Ticket(int id, double amt, String expenseType, int uId) throws InavlidExpenseTypeException {
		super();
		if (expenseType.equals("lodging")||expenseType.equals("travel")
				||expenseType.equals("food")||expenseType.equals("other")) {
			this.id = id;
			this.amt = amt;
			this.expenseType = expenseType;
			this.uId = uId;
		} else {
			throw new InavlidExpenseTypeException();
		}
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmt() {
		return amt;
	}


	public void setAmt(double amt) {
		this.amt = amt;
	}


	public String getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(String expenseType) throws InavlidExpenseTypeException {
		if (expenseType.equals("lodging")||expenseType.equals("travel")
				||expenseType.equals("food")||expenseType.equals("other")) {
			this.expenseType = expenseType;
		} else {
			throw new InavlidExpenseTypeException();
		}
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amt=" + amt + ", expenseType=" + expenseType + ", uId=" + uId + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(amt, expenseType, id, uId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Double.doubleToLongBits(amt) == Double.doubleToLongBits(other.amt)
				&& Objects.equals(expenseType, other.expenseType) && id == other.id && uId == other.uId;
	}
	
	
	
}
