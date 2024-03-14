package com.abcproducts.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static String URL = "jdbc:mysql://localhost:3306/hrc";
	private static String USERNAME = "root";
	private static String PASSWORD = "kiit1234";
	
	private Connection connection = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
