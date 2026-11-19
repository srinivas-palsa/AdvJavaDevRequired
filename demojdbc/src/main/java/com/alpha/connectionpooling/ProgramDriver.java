package com.alpha.connectionpooling;

import java.sql.Connection;
import java.sql.SQLException;

public class ProgramDriver {
	public static void main(String[] args) {
		
		ConnectionPool cp = new ConnectionPool();
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele : ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		
		System.out.println("1st OBJECT IN USE");
		Connection con1 = cp.getNewConnection();
		System.out.println(con1);
		

		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		
		System.out.println("2nd OBJECT IN USE");
		Connection con2 = cp.getNewConnection();
		System.out.println(con2);
		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		System.out.println("3nd OBJECT IN USE");
		Connection con3 = cp.getNewConnection();
		System.out.println(con3);
		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		System.out.println("4nd OBJECT IN USE");
		Connection con4 = cp.getNewConnection();
		System.out.println(con4);
		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		System.out.println("5th OBJECT IN USE");
		Connection con5 = cp.getNewConnection();
		System.out.println(con5);
		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}		
		System.out.println("6th OBJECT IN USE");
		Connection con6 = cp.getNewConnection();
		System.out.println(con6);
		
		System.out.println("OBJECTS FROM THE POOL");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
		
		
		
		try {
			con1.createStatement();
			System.out.println("STATEMENT CREATED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			cp.returnConnection(con1);
			cp.returnConnection(con2);
			cp.returnConnection(con3);
			cp.returnConnection(con3);
		}catch(RuntimeException e){
			System.out.println("CANNOT CLOSE SAME CONN MULTIPLE TIMES");
		}
		
		
		System.out.println("CONNECTIONS FROM THE POOL AFTER RETURNING");
		for(Connection ele:ConnectionPool.pool) {
			System.out.println(ele);
		}
	}
}
