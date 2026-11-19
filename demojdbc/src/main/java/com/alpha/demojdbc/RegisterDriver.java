package com.alpha.demojdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class RegisterDriver {
	public static void main(String[] args) {
		
		// 1) Registering the Driver
		Driver d = new Driver();
		
		try {
			DriverManager.registerDriver(d);
			System.out.println("Driver Registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
