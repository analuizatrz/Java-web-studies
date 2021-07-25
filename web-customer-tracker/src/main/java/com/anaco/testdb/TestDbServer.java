package com.anaco.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServer
 */
@WebServlet("/TestDbServer")
public class TestDbServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String username = "springstudent";
		String password = "springstudent";
		String driver = "com.mysql.jdbc.Driver";

		System.out.println("Connecting database...");
		try {
			PrintWriter out = response.getWriter();
			out.println("Connnecting to database");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			out.println("Connection sucessfull !");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		} catch (ClassNotFoundException e) {
			System.out.println("xii");
			e.printStackTrace();
		}
	}
}
