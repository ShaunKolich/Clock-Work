package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.skillstorm.clockwork.beans.Employee;

public class UserDao {

//Main testing
	public static void main(String[] args){

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

	public Employee getEmployeeName(String userName, String password){

		Connection conn = getConnection();
		userName.toLowerCase();

		Employee employee = null;
		try {
			PreparedStatement stmt = conn
					.prepareStatement("Select * from Employee where User_Name = ? and Password = ?;");
			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet results = stmt.executeQuery();
			results.next();
//			System.out.println("Result Found");
//			System.out.println(results.getString("UserName"));
//			System.out.println(results.getString("password"));
			conn.close();
			return new Employee(results);

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

	public boolean verifyEmployee(String user, String pass) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("Select * from users where User_Name = ? AND Password = ?;");

			stmt.setString(1, user);
			stmt.setString(2, pass);
			ResultSet results = stmt.executeQuery();
			System.out.println("Employee Dao");
			
			if (results.getString("userName").equals(user) && (results.getString("password").equals(pass))) {
				System.out.println("logged in");
				return true;
			}
			System.out.println("Credentials do not match");

		} catch (SQLException e) {

		}
		return false;

	}
}
