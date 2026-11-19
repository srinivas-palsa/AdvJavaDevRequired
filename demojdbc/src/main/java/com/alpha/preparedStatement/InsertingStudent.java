package com.alpha.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertingStudent {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);
			
			
			Scanner sc = new Scanner(System.in);
			
			
			String query = "insert into student values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			
			System.out.println("Enter Id: ");
			pstmt.setInt(1,sc.nextInt());
			System.out.println("Enter Name: ");
			pstmt.setString(2, sc.next());
			System.out.println("Enter Marks: ");
			pstmt.setDouble(3, sc.nextDouble());
			System.out.println("Enter Age: ");
			pstmt.setInt(4, sc.nextInt());
			
			int result = pstmt.executeUpdate();
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
