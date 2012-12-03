package com.legit2.hqm.Common;

import java.util.logging.Logger;

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

}
