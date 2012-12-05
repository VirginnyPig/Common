package com.legit2.hqm.Common;

public class CDatabase
{
	private static Common plugin;
	
	public static void intitializeHandler()
	{
		@SuppressWarnings("unused")
		CFlatFile SAVE;
		
		// Check if MySQL is true, and if it's even possible to connect.
		if(CSettings.mysql && CMySQL.checkConnection()) CMySQL.initializeDatabase();
		else
		{
			SAVE = new CFlatFile(plugin.getDataFolder().toString());
		}
	}
	
	public static void uninitializeHandler()
	{
		// Check if MySQL is true, and if it's even possible to connect.
		if(CSettings.mysql && CMySQL.checkConnection()) CMySQL.uninitializeDatabase();
		else
		{
			
		}
	}
}
