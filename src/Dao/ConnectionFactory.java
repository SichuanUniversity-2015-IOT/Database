package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private String driver;
	private String dburl;
	private String user;
	private String password;

	private Connection conn;

	private ConnectionFactory() {

		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (IOException e) {
			System.out.println("读取配置文件出错");
		}

		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");

	}

	private static class FactoryHolder {
		private static final ConnectionFactory instance = new ConnectionFactory();
	}

	public static ConnectionFactory getInstance() {
		return FactoryHolder.instance;
	}

	public Connection makeConnection() {
		// 数据库连接
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
