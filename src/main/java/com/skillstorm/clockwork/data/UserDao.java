package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.skillstorm.clockwork.beans.Employee;

public class UserDao {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clockwork\", \"root\", \"root");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public Employee getUserName(String userName, String password) throws ClassNotFoundException {

		Connection conn = getConnection();
		Employee UserName = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("Select * from Employee where userName = ? && password = ?");
			stmt.setString(6, userName);
			stmt.setString(4, password);

			ResultSet results = stmt.executeQuery();
			results.next();
			if (results.next()) {
				UserName = new Employee();
				UserName.setUserName(userName);
				UserName.setPassword(password);
			}
			conn.close();
			return UserName;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public Employee getEmployeeName(String UserName) {

		Connection conn = getConnection();
		Employee employeeName = null;
		try {

			PreparedStatement stmt = conn
					.prepareStatement("select First_Name, Last_Name, User_Id from employee where UserName = ?");
			stmt.setString(6, UserName);
			ResultSet results = stmt.executeQuery();
			results.next();
			employeeName = new Employee(results.getString(2), results.getNString(3), results.getInt(1));

			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return employeeName;
	}
}
