package com.alpha.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectingStudents {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			Connection con = DriverManager.getConnection(url);

			String query = "select * from student where mark>?";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setDouble(1, 80);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));
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
