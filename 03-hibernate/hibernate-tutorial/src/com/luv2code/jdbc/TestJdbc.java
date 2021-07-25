package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String username = "hbstudent";
		String password = "hbstudent";

		System.out.println("Connecting database...");
		try {
		    System.out.print("Connnecting to database");
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection sucessfull !");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
