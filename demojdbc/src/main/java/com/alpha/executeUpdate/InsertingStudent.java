package com.alpha.executeUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingStudent {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);
			
			Statement stmt = con.createStatement();
			
			String query = "insert into student values(204,'ALLEN',77.5,23)";
			
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
