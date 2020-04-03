package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variable
		String user ="springstudent";
		String pass ="springstudent";
		
		String jdbcUrl ="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String jdbcDriver ="com.mysql.cj.jdbc.Driver";
		//get a connection to the database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to Database: "+jdbcUrl);
			
			Class.forName(jdbcDriver);
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Success!!");
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
