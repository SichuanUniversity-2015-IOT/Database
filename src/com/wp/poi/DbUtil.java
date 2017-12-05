package com.wp.poi;

import java.sql.Connection;
import java.sql.DriverManager;

//连接数据库类
public class DbUtil {

	private String dbUrl = "jdbc:mysql://123.207.118.144:3306/720class";
	private String dbUserName = "ylx";
	private String dbPassword = "ylx";
	private String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
}
