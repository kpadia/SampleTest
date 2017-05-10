package com.tcs.ilp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
				
		try { 
	         Class.forName("org.postgresql.Driver"); 
	         conn = DriverManager 
	            .getConnection("jdbc:postgresql://172.29.132.192:5432/postgres", 
	            "postgres", "postgres"); 
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	         System.err.println(e.getClass().getName()+": "+e.getMessage()); 
	         System.exit(0); 
	      } 
		return conn;
	}

}
