package com.ecodation.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.ecodation.util.SingletonDbConnection;

public interface IDaoImplements<T> {

	void create(T t);

	void update(T t);

	void delete(int id);

	ArrayList<T> list();

	default Connection getInterfaceConnection() {
		SingletonDbConnection dbConnection = new SingletonDbConnection();
		return dbConnection.connectionMethod();
	}
}
