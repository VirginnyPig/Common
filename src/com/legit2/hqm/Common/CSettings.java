package com.legit2.hqm.Common;

public class CSettings
{
	
	// Database Options
	public static Boolean mysql = CConfig.getSettingBoolean("database.mysql.use");
	public static String dbName = CConfig.getSettingString("database.mysql.dbName");
	public static String username = CConfig.getSettingString("database.mysql.username");
	public static String password = CConfig.getSettingString("database.mysql.password");
	public static String host = CConfig.getSettingString("database.mysql.host");
	public static String port = CConfig.getSettingString("database.mysql.port");
	public static String tableName = CConfig.getSettingString("database.mysql.tableName");
	
}
