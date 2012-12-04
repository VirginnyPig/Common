package com.legit2.hqm.Common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import lib.PatPeter.SQLibrary.MySQL;

public class CMySQL
{
	private static MySQL mysql;
	
	/*
	 *  initializeDatabase : Connects to the database and creates user table if needed.
	 */
	public static void initializeDatabase()
	{
		CUtil.consoleMSG("info", "Initializing MySQL");
		
		// Declare handler
		mysql = new MySQL(Logger.getLogger("Minecraft"), "", CSettings.host, CSettings.port, CSettings.dbName, CSettings.username, CSettings.password);
		
		// Initialize handler
		try
		{
			mysql.open();
		}
		catch (Exception e)
		{
			CUtil.consoleMSG("severe", e.getMessage());
		}
				
		if(checkConnection())
		{
			// Success! Tell the world!
			CUtil.consoleMSG("info", "MySQL Connection Successful!");
			
			// Check to see if table exists, if not then create it
			if(!mysql.checkTable(CSettings.tableName))
			{
				CUtil.consoleMSG("info", "Creating table \"" + CSettings.tableName + "\"");
				String query = "CREATE TABLE " + CSettings.tableName + " (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, player VARCHAR(255), key VARCHAR(255), data VARCHAR(512);";
				mysql.createTable(query);
			}
		}
		else
		{
			// Connection failed... boo :(
			CUtil.consoleMSG("info", "MySQL Connection Failed."); 
		}
	}
		
	public static ResultSet runQuery(String query)
	{
		ResultSet result = null;

		try
		{
			result = mysql.query(query);
			
			if(result.next())
			{
				return result;
			}
			else return null;
		}
		catch(SQLException e)
		{
			CUtil.consoleMSG("severe", "MySQL Error: " + e);
		}
		
		return null;
	}
	
	public static void uninitializeDatabase()
	{
		mysql.close();
	}
	
	public static boolean checkConnection()
	{
		if(mysql.checkConnection()) return true;
		else return false;
	}
	
	public static ResultSet query(String query) throws SQLException
	{
		return mysql.query(query);
	}
}
