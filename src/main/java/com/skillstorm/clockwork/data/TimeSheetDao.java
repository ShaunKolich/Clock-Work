package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.skillstorm.clockwork.beans.TimeSheet;

public class TimeSheetDao {

	public Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clockwork", "root", "root");
			return conn;

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public Set<TimeSheet> searchByEmployee(String UserName) {
		Connection conn = getConnection();
		Set<TimeSheet> results = new HashSet<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from Hours inner join employee on employee.User_Id = hours.User_Id where employee.UserName like ?");
			stmt.setString(1, UserName + "%");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				TimeSheet employee = new TimeSheet(result.getInt(1), result.getInt(2), result.getDouble(3));
				TimeSheet Employee = new TimeSheet(result.getDouble(4), result.getDouble(5), result.getDouble(6),
						result.getDouble(7), result.getDouble(8));
				results.add(employee);
				results.add(Employee);
			}
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

	public void update(TimeSheet timesheet) {
		Connection conn = getConnection();
		String sql = "update hours h inner join employee e on e.User_Id = h.User_Id Set Mon_Hours = ?, Tues_Hours = ?, Wed_Hours = ?, Thurs_Hours = ?, Fri_Hours = ? where e.UserName like ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, timesheet.getMon_Hours());
			stmt.setDouble(2, timesheet.getTues_Hours());
			stmt.setDouble(3, timesheet.getWeds_Hours());
			stmt.setDouble(4, timesheet.getThurs_Hours());
			stmt.setDouble(5, timesheet.getFri_Hours());
			stmt.executeUpdate();
			conn.commit();

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

}
