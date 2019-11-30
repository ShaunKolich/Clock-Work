package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.skillstorm.clockwork.beans.Employee;

public class UserDao {

//Main testing
	public static void main(String[] args) {

		UserDao user = new UserDao();

//		user.getUserName("skolich", "test");
//		System.out.println(user.getUserName("skolich", "test"));
		user.getEmployeeName("skolich", null);
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/clockwork";
			conn = DriverManager.getConnection(url, "root", "root");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public Employee getEmployeeName(String username, String pass) {

		Connection conn = getConnection();
		username.toLowerCase();

//		Employee employee = null;
		try {
			PreparedStatement stmt = conn
					.prepareStatement("Select * from Employee where User_Name = ? and Password = ?;");
			stmt.setString(1, username);
			stmt.setString(2, pass);
			ResultSet results = stmt.executeQuery();
			results.next();
//			
			System.out.println("Get Employee");
//			System.out.println(userName);
//			System.out.println(password);

			return new Employee(results);

		} catch (SQLException e) {
			return new Employee();
		}

	}

	public boolean verifyEmployee(String userName, String password) {
		Connection conn = getConnection();
		try {
			userName.toLowerCase();
			PreparedStatement stmt = conn
					.prepareStatement("Select * from Employee where User_Name = ? AND Password = ?;");

			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet results = stmt.executeQuery();
//		System.out.println(user +" "+ pass);
			System.out.println("Result set for verify user " + results.getString("userName") + " "
					+ results.getString("password"));
			System.out.println("Results from params " + userName + " " + password);

			if (results.getString("userName").equals(userName) && (results.getString("password").equals(password))) {
//				System.out.println("logged in");
				System.out.println("Employee Dao");
				return true;
			}
			System.out.println("Credentials do not match");

		} catch (SQLException e) {

		}
		return false;

	}
}
