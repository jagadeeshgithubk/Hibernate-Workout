package com.test.controller;

import java.sql.SQLException;

public interface TestService {

	public Integer executeQuery(String name) throws SQLException;
}
