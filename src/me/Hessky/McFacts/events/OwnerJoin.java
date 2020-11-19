package me.Hessky.McFacts.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Hessky.McFacts.main;
import me.Hessky.McFacts.utils.UpdateChecker;
import me.Hessky.McFacts.utils.Utils;

public class OwnerJoin implements Listener{
	
	  @EventHandler
	    public void pJoin(PlayerJoinEvent e) {
	        Player p = e.getPlayer();
	        if(main.plugin3.getConfig().getBoolean("updatecheck")) {
	            if(p.isOp()) {
	                try {
	                    p.sendMessage("Checking for updates [McFacts]...");
	                    UpdateChecker updater = new UpdateChecker(main.plugin3, 82149);
	                    if(updater.checkForUpdates()) {
	                        p.sendMessage(Utils.chat(main.plugin3.getConfig().getString("prefix") + " &l&6NEW UPDATE FOR MCFACTS DOWNLOAD IT- &ehttps://www.spigotmc.org/resources/minecraft-facts.82149/updates"));
	                    }else{
	                        
	                    }
	                }catch(Exception e1) {
	                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Could not proceed update-checking!");
	                }
	            }
	        }
	    }

}
