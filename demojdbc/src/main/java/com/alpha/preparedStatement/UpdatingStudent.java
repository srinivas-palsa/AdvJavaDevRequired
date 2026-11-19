package com.alpha.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatingStudent {
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);
			
			
			Scanner sc = new Scanner(System.in);
			
			
			String query = "update student set mark=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			
			System.out.println("Enter ID: ");
			pstmt.setInt(2, sc.nextInt());
			System.out.println("Enter Marks to be Updated: ");
			pstmt.setDouble(1, sc.nextDouble());
			
			System.out.println(pstmt.executeUpdate());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
