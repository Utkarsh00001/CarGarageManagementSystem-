package com.guarage.configue.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHelper {
	protected DatabaseConfigue db = DatabaseConfigue.getDBInstance();
	protected Connection con = DatabaseConfigue.getConnection();
	protected PreparedStatement ps = DatabaseConfigue.getPreparedStatement();
	protected ResultSet rs = DatabaseConfigue.getResultSet();
}
