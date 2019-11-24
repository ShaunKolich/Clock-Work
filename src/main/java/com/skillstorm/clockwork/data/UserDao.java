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

	public static void main(String[] args) throws ClassNotFoundException {

		UserDao user = new UserDao();

		user.getUserName("skolich", "test");
		System.out.println(user.getUserName("skolich", "test"));

	}

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
		Employee employee = null;
		try {
			PreparedStatement stmt = conn
					.prepareStatement("Select * from Employee where userName = ? and password = ?;");
			stmt.setString(1, userName);
			stmt.setString(2, password);

			ResultSet results = stmt.executeQuery();
			results.next();

			System.out.println("Result Found");
			Employee userName1 = new Employee();
			userName1.setUserName(results.getString("UserName"));
			userName1.setPassword(results.getString("password"));

			employee = new Employee (results.getString("UserName"),(results.getString("password")));
			System.out.println(results.getString("UserName"));
			System.out.println(results.getString("password"));
			conn.close();
			return userName1;

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
					.prepareStatement("select First_Name, Last_Name, User_Id from employee where UserName LIKE ?;");
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
