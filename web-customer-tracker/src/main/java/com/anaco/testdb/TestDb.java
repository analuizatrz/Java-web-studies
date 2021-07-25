package com.anaco.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDb {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String username = "springstudent";
		String password = "springstudent";

		System.out.println("Connecting database...");
		try {
			System.out.println("Connnecting to database");
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection sucessfull !");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
