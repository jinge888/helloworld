package com.yaolala.dobigthing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSet2EntityMapping {

	Object mapping(ResultSet rs) throws SQLException;
}
