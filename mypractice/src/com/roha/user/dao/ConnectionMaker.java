/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB connection Interface
 * @author Roha Park
 *
 */
public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
