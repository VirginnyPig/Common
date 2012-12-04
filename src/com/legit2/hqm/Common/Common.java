package com.legit2.hqm.Common;

import org.bukkit.plugin.java.JavaPlugin;

public class Common extends JavaPlugin
{
	public CListener listener;
	
	@Override
	public void onEnable()
	{
		// Initialize plugin
		new CConfig(this);
		
		CDatabase.intitializeHandler();
		loadCommands();
		loadListeners();

		CUtil.consoleMSG("info", "Enabled!");
	}

	@Override
	public void onDisable()
	{	
		// Uninitialize plugin
		CDatabase.uninitializeHandler();
		
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
}
