package com.alpha.connectionpooling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
	static ArrayList<Connection> pool = new ArrayList<Connection>();
	private final static int poolsize=5;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
		for(int i=1; i<=poolsize;i++) {
			try {
				pool.add(DriverManager.getConnection(url));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Connection getNewConnection() {
		Connection con = null;
		
		if(pool.size()>0) {
			con = pool.remove(pool.size()-1);
		}
		else {
			String url = "jdbc:postgresql://localhost:5432/demojdbc?user=postgres&password=root";
			try {
				con = DriverManager.getConnection(url);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void returnConnection(Connection con) {
		if(pool.size()<poolsize) {
			for(Connection connection : pool) {
				if(connection.equals(con)) {
					throw new RuntimeException();
				}
			}
			pool.add(con);
		}
		else {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
