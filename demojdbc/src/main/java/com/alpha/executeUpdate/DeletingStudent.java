package com.alpha.executeUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletingStudent {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String credentials = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(credentials);
			
			Statement stmt = con.createStatement();
			
			String query = "delete from student where age=23";
			int result = stmt.executeUpdate(query);
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
