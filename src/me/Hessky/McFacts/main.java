package me.Hessky.McFacts;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.Hessky.McFacts.commands.Facts;
import me.Hessky.McFacts.commands.Tiers;
import me.Hessky.McFacts.utils.Utils;


public class main extends JavaPlugin{
	
		
	
		@Override
		public void onEnable() {
			saveDefaultConfig();
			runnable();
			new Tiers(this);
			new Facts(this);
			System.out.println("\n\n --- MCFACTS PLUGIN ENABLED --- \n\n");
	}
	
		@Override
		public void onDisable() {
			System.out.println("\n\n --- MC FACTS PLUGIN DISABLED --- \n\n");
	}
	
		//Auto fact
		public void runnable() {
		new BukkitRunnable() {
			@Override
			public void run() {
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
		}.runTaskTimerAsynchronously(this, 0, getConfig().getInt("autofactTime")*20);
	}
	
}
