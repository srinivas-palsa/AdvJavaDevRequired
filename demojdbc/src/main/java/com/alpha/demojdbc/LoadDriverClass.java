package com.alpha.demojdbc;

public class LoadDriverClass {
	public static void main(String[] args) {
		
		// 1) Load the Driver
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("DRIVER LOADED");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
