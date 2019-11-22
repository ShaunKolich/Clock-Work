package com.skillstorm.clockwork.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.data.UserDao;

public class ServletController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		
		try {
			Employee Username = userDao.getUserName(userName,password);
		
			if(Username !=null) {
				HttpSession session = req.getSession();
				session.setAttribute("User", Username);
				resp.sendRedirect("src\\main\\webapp\\WEB-INF\\timesheet.html");
				
			}else {
				String message = "Invalid Username or Password";
				req.setAttribute("message", message);
			}
			
		}
		catch (SQLException | ClassNotFoundException e){
			throw new ServletException();
		}
		
		
}
