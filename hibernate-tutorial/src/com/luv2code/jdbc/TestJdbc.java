package com.luv2code.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) {
		var url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		var username = "hbstudent";
		var password = "hbstudent";

		System.out.println("Connecting database...");
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
		    System.out.print("Connnecting to database");
			var conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection sucessfull !");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
