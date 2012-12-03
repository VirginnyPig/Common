package com.legit2.hqm.Common;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCommandExecutor implements CommandExecutor {
	
	
	static Common plugin;
	
	public CCommandExecutor(Common c) {
		plugin = c;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		// Define player
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		
		/*
		 * Command 'common'
		 */
		if (command.getName().equalsIgnoreCase("common"))
		{
			// Check for permission
			if (!CUtil.hasPermissionOrOP(player, "common.info")) return noPermission(player);
			
			sender.sendMessage(ChatColor.RED + "Source Code:");
			sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
			return true;
		} 
		/*
		 * Command 'commonplayer'
		 */
		else if (command.getName().equalsIgnoreCase("commonplayer"))
		{
			// Check for console
			if (player == null) return noConsole(sender);
			
			// Check for permission
			if (!CUtil.hasPermissionOrOP(player, "common.info")) return noPermission(player);
			
			sender.sendMessage(ChatColor.RED + "Source Code:");
			sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
			return true;
		}
		/*
		 * Command 'commonconsole'
		 */
		else if (command.getName().equalsIgnoreCase("commonconsole"))
		{
			// Check for player
			if (player != null) return noPlayer(sender);
			
			sender.sendMessage(ChatColor.RED + "Source Code:");
			sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
			return true;
		}
		
		return false;
	}

	private boolean noPermission(Player player)
	{
		// CommandSender does not have permission to run command.
		player.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
		return true;
	}
	
	private boolean noConsole(CommandSender sender)
	{
		// Sender was not a player, send message
		sender.sendMessage("This command can only be executed by a player.");
		return false;
	}
	
	private boolean noPlayer(CommandSender sender)
	{
		// Sender was not the console, send message
		sender.sendMessage("This command can only be executed by the console.");
		return false;
	}
	
}
