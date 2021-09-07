package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.config.DBUtil;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("username");
		String passwd = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		Connection conn = DBUtil.getConnection();
		
		String sql = "insert into user values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, passwd);
			ps.setString(3, phone);
			
			ps.executeUpdate(); //insert, update,delete
			out.println("Data Stored Suvvessfully!");
		} catch (SQLException e) {
			out.println("Connection Error!");
			e.printStackTrace();
		}
		
		
	}
}
