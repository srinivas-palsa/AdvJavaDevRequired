package com.alpha.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoStudentTable {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			
			String url ="jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);
			
			Statement stmt=con.createStatement();
			
			String query="insert into student values(102,'Allen',90.5,23)";
			
			boolean result = stmt.execute(query);	
			System.out.println(result);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
