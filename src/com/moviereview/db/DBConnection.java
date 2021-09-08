package com.moviereview.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"semi","project");	
		}catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage());	
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		return con;		
	}
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) rs.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}


   













