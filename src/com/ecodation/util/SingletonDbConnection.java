package com.ecodation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.java.Log;

@Log
public class SingletonDbConnection {
	private Connection connection;

	// Db connection
	private String user = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/blogdb?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";

	// database baglanma metodu
	public Connection connectionMethod() {

		try {
			if (this.connection == null || this.connection.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					// log.info("Driver yüklendi");
					connection = DriverManager.getConnection(url, user, password);
					// log.info("Baglanti basarili");
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
					log.warning("Genel hata" + e);
					// throw (e);
				}
			}
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		return connection;
	}

	public static void main(String[] args) {
		SingletonDbConnection connection55 = new SingletonDbConnection();
		connection55.connectionMethod();
	}

}
