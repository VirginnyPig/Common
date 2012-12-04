package com.legit2.hqm.Common;

import org.bukkit.plugin.java.JavaPlugin;

public class Common extends JavaPlugin
{
	
	public CListener listener;
	CFlatFile SAVE;
	
	@Override
	public void onEnable()
	{
		// Initialize plugin
		new CConfig(this);
		
		loadCommands();
		loadListeners();
		loadDatabase();

		CUtil.consoleMSG("info", "Enabled!");
	}

	@Override
	public void onDisable()
	{
		unloadDatabase();
		
		CUtil.consoleMSG("info", "Disabled!");
	}
	
	private void loadCommands()
	{
		// Define CommandExecutor
		CCommandExecutor ce = new CCommandExecutor(this);
		
		// info
		getCommand("common").setExecutor(ce);
		getCommand("commonplayer").setExecutor(ce);
		getCommand("commonconsole").setExecutor(ce);
	}
	
	private void loadListeners()
	{
		// Define Listener
		CListener li = new CListener(this);
		
		// Start Listener
		getServer().getPluginManager().registerEvents(li, this);
	}
	
	private void loadDatabase()
	{
		// Check if MySQL is true, and if it's even possible to connect.
		if(CSettings.mysql && CDatabase.checkConnection()) CDatabase.initializeDatabase();
		else
		{
			SAVE = new CFlatFile(this.getDataFolder().toString());
			
		}
	}
	
	private void unloadDatabase()
	{
		// Check if MySQL is true, and if it's even possible to connect.
		if(CSettings.mysql && CDatabase.checkConnection()) CDatabase.uninitializeDatabase();
		else
		{
			
			
		}
	}
}
