package com.alpha.batchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudentsUsingBatch {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);

			String query = "insert into student values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			for (int i = 1; i <= 3; i++) {
				System.out.println("Enter id: ");
				pstmt.setInt(1, sc.nextInt());
				
				System.out.println("Enter name: ");
				pstmt.setString(2,sc.next());
				
				System.out.println("Enter marks: ");
				pstmt.setDouble(3, sc.nextDouble());
				
				System.out.println("Enter age: ");
				pstmt.setInt(4, sc.nextInt());
				
				pstmt.addBatch();
			}
			
			int[] res= pstmt.executeBatch();
			
			for(int i:res) {
				System.out.println(i);
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
