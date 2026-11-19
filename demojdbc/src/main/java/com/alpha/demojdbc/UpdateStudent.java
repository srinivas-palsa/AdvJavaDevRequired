package com.alpha.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc";
			String username = "postgres";
			String password="root";			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String query = "update student set mark=70.5 where id=102";
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
