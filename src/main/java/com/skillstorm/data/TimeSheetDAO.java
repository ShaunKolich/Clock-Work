package com.skillstorm.data;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillstorm.javabeans.TimeSheet;
import com.skillstorm.javabeans.User;

public class TimeSheetDAO {

	public Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/timesheet";
			conn = DriverManager.getConnection(url, "root", "root");
			return conn;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return conn;
		}

	}

	public TimeSheet getTimeSheetById(int i) {

		Connection conn = getConnection();

		try {
			// run sql commands
			PreparedStatement stm = conn.prepareStatement("Select * from timesheet where timesheetId = ? ;");
			stm.setInt(1, i);
			ResultSet results = stm.executeQuery(); // wll return the rowcount
			results.next();
			TimeSheet timeSheet = new TimeSheet(results);

			return timeSheet;

		} catch (SQLException e) {

			System.out.println(e);
			return new TimeSheet();
		}

	}

	public List<TimeSheet> findAllTimeSheet() {

		List<TimeSheet> timeList = new ArrayList<>();

		try {

			Connection conn = getConnection();
			// run sql commands
			PreparedStatement stm = conn.prepareStatement("Select * from timesheet;");
			// stm.setInt(1, i);
			ResultSet results = stm.executeQuery(); // wll return the rowcount

			results.next();

			while (results.next()) {

				timeList.add(new TimeSheet(results));

			}

			return timeList;

		} catch (SQLException e) {

			System.out.println(e);
			return timeList;

		}

	}

	public void save(TimeSheet t) {

		try {

			if (t.getMonHours() < 0) {
				
				throw new SQLException();
			}

			int savedTimeSheetId = t.getTimeSheetId();

			Connection conn = getConnection();
			// run sql commands
			PreparedStatement stm = conn.prepareStatement("UPDATE timesheet SET "
					+ "mon_hours = ?, tue_hours = ?, wed_hours = ?, thu_hours = ?, fri_hours = ?"
					+ "WHERE timesheetID = ?; ");
			
			stm.setFloat(1, t.getMonHours());
			stm.setFloat(2, t.getTueHours());
			stm.setFloat(3, t.getWedHours());
			stm.setFloat(4, t.getThuHours());
			stm.setFloat(5, t.getFriHours());
			stm.setInt(8, t.getStatusId());
			stm.setInt(9, t.getTimeSheetId());

			System.out.println("stm query statement: " + stm.toString());
			int rowAffected = stm.executeUpdate(); // wll return the rowcount

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void addNewTimeSheet(int userId, String parsedDate) {

		Connection conn = getConnection();
		// run sql commands

		try {

			PreparedStatement stm = conn.prepareStatement("Insert into timesheet (userId, endDate)  Values( ?, ? ) ;");

			stm.setInt(1, userId);
			stm.setString(2, parsedDate);
			System.out.println("Prepared Stm to be added " + stm.toString());

			stm.executeUpdate(); 

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public List<TimeSheet> findTimeSheetsByUser(int userId) {

		Connection conn = getConnection();
		List<TimeSheet> timeList = new ArrayList<>();
		System.out.println("Getting the list " + userId);
		try {

			PreparedStatement stm = conn.prepareStatement("Select * from timesheet where userId = ?");
			stm.setInt(1, userId);
			// stm.setInt(1, i);
			ResultSet result = stm.executeQuery(); // wll return the rowcount
			result.next();
			System.out.println("test" + userId);
			while (result.next()) {
				timeList.add(new TimeSheet(result));
			}

			return timeList;

		} catch (SQLException e) {
			System.out.println("FindTimeSheetByUser DAO: " + e);
			return timeList;
		}

	}

	public void deleteTimeSheet(int i) {

		Connection conn = getConnection();

		try {
			System.out.println("Delete called in Dao: ");

			PreparedStatement stm = conn.prepareStatement("Delete from timesheet where timeSheetId = ? ;");
			stm.setInt(1, i);
			// stm.setInt(1, i);
			int results = stm.executeUpdate(); // wll return the rowcount

			System.out.println("Rows affected " + results);

		} catch (SQLException e) {
			

		}

	}

	public boolean dateExist(int userId, String parsedDate) {

		Connection conn = getConnection();
		// run sql commands

		try {

			PreparedStatement stm = conn
					.prepareStatement("Select endDate from timesheet where userId = ? AND endDate = ? ;");

			stm.setInt(1, userId);
			stm.setString(2, parsedDate);
			System.out.println("Prepared Stm to be added " + stm.toString());

			ResultSet result = stm.executeQuery(); // wll return the rowcount

			if (result.next()) {

				return true;

			}

			return false;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}

	}

}