package com.legit2.hqm.Common;

import java.sql.ResultSet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

@SuppressWarnings("unused")
public class CListener implements Listener
{
	

private static Common plugin;
	
	public CListener(Common common)
	{
		plugin = common;
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLogin(PlayerLoginEvent login)
	{
		// Define variables and do formatting stuff
		Player player = login.getPlayer();
		String username = login.getPlayer().getName();
		
		// Create our query string and a null result variable to hold returned data
		String query = "SELECT * FROM " + CSettings.tableName + " WHERE username = '" + username + "';";
		ResultSet result = null;
		
		CUtil.consoleMSG("info", username + " just logged in!");
		
		
	}
	
}
