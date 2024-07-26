package com.guarage.configue.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DatabaseConfigue {
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static DatabaseConfigue dbc = null;

	private DatabaseConfigue() {
		try {
			Properties p = new Properties();
			p.load(DatabaseRoots.finf);
			String driver = p.getProperty("driver");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String url = p.getProperty("url");
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			if (con != null) {
				System.out.println("connected to the database");
			} else {
				System.out.println("not connected to the database");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static DatabaseConfigue getDBInstance() {
		if (dbc == null) {
			return dbc = new DatabaseConfigue();
		}
		return dbc;
	}
	public static Connection getConnection() {
		return con;
	}
	public static PreparedStatement getPreparedStatement() {
		return ps;
	}
	public static ResultSet getResultSet() {
		return rs;
	}
}
