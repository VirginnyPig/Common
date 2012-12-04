package com.legit2.hqm.Common;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Common extends JavaPlugin implements Listener
{
	
	@Override
	public void onEnable()
	{
		// Inizialize plugin
		loadCommands();
		loadListeners();

		CUtil.consoleMSG("info", "Enabled!");
	}

	@Override
	public void onDisable()
	{
		CUtil.consoleMSG("info", "Disabled!");
	}
	
	private void loadCommands()
	{
		CCommandExecutor ce = new CCommandExecutor(this);
		
		// info
		getCommand("common").setExecutor(ce);
		getCommand("commonplayer").setExecutor(ce);
		getCommand("commonconsole").setExecutor(ce);
	}
	
	private void loadListeners()
	{
		getServer().getPluginManager().registerEvents(this, this);
	}
}
