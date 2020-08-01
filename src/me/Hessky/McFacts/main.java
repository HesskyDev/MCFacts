package me.Hessky.McFacts;

import org.bukkit.plugin.java.JavaPlugin;

import me.Hessky.McFacts.commands.Facts;

public class main extends JavaPlugin{
	
	
	
	@Override
	public void onEnable() {
		getCommand("facts").setExecutor(new Facts());
		System.out.println("\n\n --- MCFACTS PLUGIN ENABLED --- \n\n");
	}
	
	@Override
	public void onDisable() {
		System.out.println("\n\n --- MC FACTS PLUGIN DISABLED --- \n\n");
	}
	
	
}
