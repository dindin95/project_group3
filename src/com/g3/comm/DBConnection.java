package com.g3.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	//singleton
	private static DBConnection dbInstance = new DBConnection();
	public static DBConnection getDBConn() {
		return dbInstance;
	}
	public DBConnection() {}

	//DB 연결
	public Connection getConnection() throws SQLException, NamingException {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/kosta");
		Connection conn = ds.getConnection();

		return conn;
	}
}
