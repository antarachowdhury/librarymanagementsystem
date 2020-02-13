package com.campegmini.librarymanagementsystem.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection intializeConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";
		Connection conn = DriverManager.getConnection(dburl, "antara", "system");
		return conn;

	}
}
