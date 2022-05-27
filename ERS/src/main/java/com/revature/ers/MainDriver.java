package com.revature.ers;

import com.revature.utils.ConnectionFactory;

public class MainDriver {
	
	public static void main(String...args) {
		ConnectionFactory.getConnection();
		System.out.println("hello world");
	}
}
