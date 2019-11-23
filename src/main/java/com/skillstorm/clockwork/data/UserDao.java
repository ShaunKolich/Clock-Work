package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

import com.skillstorm.clockwork.beans.Employee;

public class UserDao {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clockwork", "root", "root");
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
//			stmt.setInt(1, user_Id);

			ResultSet results = stmt.executeQuery();
			results.next();
			if (results.next()) {
				UserName = new Employee();
				UserName.setUserName(userName);
				UserName.setPassword(password);
//				UserName.setUser_Id(user_Id);
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

	public Set<Employee> getEmployeeName(String UserName) {

		Set<Employee> results = new HashSet<>();
		Connection conn = getConnection();
		Employee employeeName = null;
		try {

			PreparedStatement stmt = conn
					.prepareStatement("select First_Name, Last_Name, User_Id from employee where UserName LIKE ?");
			stmt.setString(6, UserName + "%");
			ResultSet result = stmt.executeQuery();
			result.next();
			while (result.next()) {
				employeeName = new Employee(result.getString(2), result.getString(3), result.getString(1));
				results.add(employeeName);
			}
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
		return results;
	}
}
