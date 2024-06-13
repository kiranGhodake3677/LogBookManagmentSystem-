package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTable1 {
	public static Connection con() throws ClassNotFoundException, Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/applogin","root","Root@123");
		return con;
}
}