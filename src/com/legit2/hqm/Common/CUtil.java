package com.legit2.hqm.Common;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CUtil {

	@SuppressWarnings("unused")
	private static Common plugin;
	
	// Define variables
	static String pluginName = "Common";

	/*
	 *  consoleMSG : Send (String)msg to the console with level (String)level.
	 */
	public static void consoleMSG(String level, String msg)
	{
		// Define variables
		Logger log = Logger.getLogger("Minecraft");
		
		if(level.equalsIgnoreCase("info")) log.info("[" + pluginName + "] " + msg);
		if(level.equalsIgnoreCase("warning")) log.warning("[" + pluginName + "] " + msg);
		if(level.equalsIgnoreCase("severe")) log.severe("[" + pluginName + "] " + msg);
	}
	
	/*
	 *  hasPermission : Checks if (Player)p has permission (String)pe.
	 */
	public static boolean hasPermission(Player player, String permission)
	{
		if (player == null) return true;
		return player.hasPermission(permission);
	}

	/*
	 *  hasPermissionOrOP : Checks if (Player)p has permission (String)pe, or is OP.
	 */
	public static boolean hasPermissionOrOP(Player player, String permission)
	{
		if (player == null) return true;
		if (player.isOp()) return true;
		return player.hasPermission(permission);
	}

	/*
	 *  noPermission : Displays a message to (Player)player and then returns true.
	 */
	public static boolean noPermission(Player player)
	{
		// CommandSender does not have permission to run command.
		player.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
		return true;
	}
	
	/*
	 *  noConsole : Displays a message to (CommandSender)sender and then returns true.
	 */
	public static boolean noConsole(CommandSender sender)
	{
		// Sender was not a player, send message
		sender.sendMessage("This command can only be executed by a player.");
		return true;
	}
	
	/*
	 *  noPlayer : Displays a message to (CommandSender)sender and then returns true.
	 */
	public static boolean noPlayer(CommandSender sender)
	{
		// Sender was not the console, send message
		sender.sendMessage("This command can only be executed by the console.");
		return true;
	}
	
	/*
	 *  definePlayer : Defines the player from (CommandSender)sender.
	 */
	public static Player definePlayer(CommandSender sender)
	{
		// Define player
		Player player = null;
		if (sender instanceof Player)
		player = (Player) sender;
		
		return player;
	}	
	
}
