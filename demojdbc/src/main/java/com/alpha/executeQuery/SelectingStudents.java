package com.alpha.executeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectingStudents {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc";
			String username = "postgres";
			String password = "root";
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement stmt = con.createStatement();
			
			String query = "select * from student";
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("ID"+" NAME"+" MARKS"+" AGE");
			System.out.println("-------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4));
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getDouble(3));
//				System.out.println(rs.getInt(4));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
