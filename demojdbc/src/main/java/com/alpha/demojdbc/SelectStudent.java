package com.alpha.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class SelectStudent {
	public static void main(String[] args) {
		Driver d = new Driver();
		
		try {
			DriverManager.registerDriver(d);
			
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);
			
			Statement stmt = con.createStatement();
			
			String query = "select * from student";
			boolean result = stmt.execute(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
