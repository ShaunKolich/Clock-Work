package com.skillstorm.clockwork.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class TimeSheetDao {

	public Connection getConnection(){
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection("")
		
		
		}
		
		return null;
		
	}
}
