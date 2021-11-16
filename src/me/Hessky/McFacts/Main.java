package me.Hessky.McFacts;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.Hessky.McFacts.commands.Facts;
import me.Hessky.McFacts.commands.McFactsReload;
import me.Hessky.McFacts.commands.Tiers;
import me.Hessky.McFacts.events.FactBookEvent;
import me.Hessky.McFacts.events.StopPlace;
import me.Hessky.McFacts.events.UpdateCheckerJoin;
import me.Hessky.McFacts.utils.Recipes;
import me.Hessky.McFacts.utils.UpdateChecker;
import me.Hessky.McFacts.utils.Utils;


public class Main extends JavaPlugin{
	
		public static Main instance;
		public static Main plugin3;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		saveDefaultConfig();
		plugin3 = this;
		instance = this;
		runnable();
		Recipes.Recipe();
		new Tiers(this);
		new Facts(this);
		getCommand("MCFactsReload").setExecutor(new McFactsReload());
		this.getServer().getPluginManager().registerEvents(new UpdateCheckerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new StopPlace(), this);
		this.getServer().getPluginManager().registerEvents(new FactBookEvent(), this);
		
		System.out.println("\n\n --- MCFACTS PLUGIN ENABLED --- \n\n");
		
		//Update checker
		new UpdateChecker(this, 82149).getVersion(version -> {
			
	           if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
	        	   
	               this.getLogger().info("McFacts is up to date!");
	           } else {
	        	   
	               this.getLogger().info("There is a new update available for McFacts!");
	           }
	      });
	}
	
		@Override
	public void onDisable() {
		System.out.println("\n\n --- MC FACTS PLUGIN DISABLED --- \n\n");
	}
		
		
	public static Main getInstance() {
		return instance;
	}
		
		//Auto fact
	public void runnable() {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				
				if(getConfig().getBoolean("autofact.enable")) {
					
					int randomnum = (int) (Math.random()*1000);
					
					//Legendary fact
					if(randomnum <= getConfig().getInt("legendarychance")) {
						
						Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("legendarycolor") + getConfig().getList("legendaryfacts").get((int)(Math.random()*getConfig().getList("legendaryfacts").size()))));
					}else {
						
						//Epic fact
						if(randomnum <= getConfig().getInt("epicchance")  + getConfig().getInt("legendarychance")) {
							Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("epiccolor") + getConfig().getList("epicfacts").get((int)(Math.random()* getConfig().getList("epicfacts").size()))));
						}else {
							
							//Rare fact
							if(randomnum <= getConfig().getInt("rarechance") + getConfig().getInt("epicchance")){
								Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("rarecolor") + getConfig().getList("rarefacts").get((int)(Math.random()* getConfig().getList("rarefacts").size()))));
							}else {
								
								//Normal Fact
								Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("factcolor") + getConfig().getList("commonfacts").get((int)(Math.random()*getConfig().getList("commonfacts").size()))));
							}
						}
					}
				}	
			}
		}.runTaskTimerAsynchronously(this, 10, getConfig().getInt("autofact.time")*20);
	}
	
}
