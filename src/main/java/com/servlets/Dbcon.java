package com.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {

	public static Connection getCon() throws Exception{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
		return con;
	}
	
}
