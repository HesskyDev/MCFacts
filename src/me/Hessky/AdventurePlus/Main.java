package me.Hessky.AdventurePlus;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.Hessky.AdventurePlus.commands.adventuretips;
import me.Hessky.AdventurePlus.commands.travel;
import me.Hessky.AdventurePlus.events.customdrop;
import me.Hessky.AdventurePlus.events.superzombie;

public class Main extends JavaPlugin
{
    public void onEnable() {
    	saveDefaultConfig();
        //commands and events register
        this.getCommand("travel").setExecutor((CommandExecutor)new travel());
        this.getCommand("adventuretips").setExecutor((CommandExecutor)new adventuretips());
        this.getServer().getPluginManager().registerEvents((Listener)new customdrop(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new superzombie(), (Plugin)this);
        System.out.println("\n \n [ADV+] PLUGIN ENABLED \n \n");
    }
    
    public void onDisable() {
    	System.out.println("\n \n [ADV+] PLUGIN DISABLED \n \n");
    }
}