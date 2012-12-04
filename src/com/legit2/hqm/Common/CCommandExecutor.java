package com.legit2.hqm.Common;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCommandExecutor implements CommandExecutor
{
	
	static Common plugin;
	
	public CCommandExecutor(Common common)
	{
		plugin = common;
	}
	
	/*
	 * Command 'common'
	 */
	public static Boolean common(CommandSender sender)
	{
		// Define player
		Player player = CUtil.definePlayer(sender);
		
		// Check for permission
		if (!CUtil.hasPermissionOrOP(player, "common.info")) return CUtil.noPermission(player);
		
		sender.sendMessage(ChatColor.RED + "Source Code:");
		sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
		return true;
	}
	
	/*
	 * Command 'commonplayer'
	 */
	public static Boolean commonPlayer(CommandSender sender)
	{
		// Define player
		Player player = CUtil.definePlayer(sender);
		
		// Check for console
		if (player == null) return CUtil.noConsole(sender);
		
		// Check for permission
		if (!CUtil.hasPermissionOrOP(player, "common.info")) return CUtil.noPermission(player);
		
		sender.sendMessage(ChatColor.RED + "Source Code:");
		sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
		return true;
	}
	
	/*
	 * Command 'common'
	 */
	public static Boolean commonConsole(CommandSender sender)
	{
		// Define player
		Player player = CUtil.definePlayer(sender);
		
		// Check for player
		if (player != null) return CUtil.noPlayer(sender);
		
		// Check for permission
		if (!CUtil.hasPermissionOrOP(player, "common.info")) return CUtil.noPermission(player);
		
		sender.sendMessage(ChatColor.RED + "Source Code:");
		sender.sendMessage(ChatColor.RED + "https://github.com/HmmmQuestionMark/Common");
		return true;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(command.getName().equalsIgnoreCase("common")) return common(sender);
		if(command.getName().equalsIgnoreCase("commonplayer")) return commonPlayer(sender);
		if(command.getName().equalsIgnoreCase("commonconsole")) return commonConsole(sender);
		return false;
	}

}
