package com.alpha.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EstablishConnection {
	public static void main(String[] args) {
		
		try {
			
			//1) Load the Driver
			Class.forName("org.postgresql.Driver");
			
			
			//2) Establish Connection
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
//			String username = "postgres";
//			String pass = "root";
			
//			Connection con = DriverManager.getConnection(url, username, pass);
			Connection con = DriverManager.getConnection(url);
			System.out.println(con);
			System.out.println("CONNECTION ESTABLISHED");
			
			
			
			//3) Create Statement
			Statement stmt = con.createStatement();
			System.out.println(stmt);
			System.out.println("Statement Created");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
