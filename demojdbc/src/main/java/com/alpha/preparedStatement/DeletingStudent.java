package com.alpha.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletingStudent {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);

			Scanner sc = new Scanner(System.in);

			String query = "delete from student where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("Enter Id: ");
			pstmt.setInt(1, sc.nextInt());

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
