package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.config.DBUtil;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String user = request.getParameter("username");
		String passwd = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("phone"));

		User u = new User(user, passwd, phone);
		UserDAO dao = new UserDAOImpl();

		boolean status = dao.saveUser(u);

		RequestDispatcher rd = null;
		if (status) {
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}

	}
}
