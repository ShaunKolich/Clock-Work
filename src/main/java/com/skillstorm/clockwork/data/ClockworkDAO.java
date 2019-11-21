package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.skillstorm.clockwork.beans.Employee;

public class ClockworkDAO {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clockwork\", \"root\", \"root");
			return conn;
		}
		catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException (e);
		}
		
	}

//	public Employee save(Employee, employee) {
//	 
//		
//		try {
//			
//		}
//	}
	
	
	
}

