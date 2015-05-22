package com.test.controller;

import java.sql.SQLException;

public interface TestService {

	Integer executeQuery(String name) throws SQLException;
	
	interface TestServiceChild{
		void childMethod();
	}
}
