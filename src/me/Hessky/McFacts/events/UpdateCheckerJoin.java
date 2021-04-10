package me.Hessky.McFacts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Hessky.McFacts.main;
import me.Hessky.McFacts.utils.UpdateChecker;
import me.Hessky.McFacts.utils.Utils;

public class UpdateCheckerJoin implements Listener{

	
	@EventHandler
	public void pJoin(PlayerJoinEvent e) {
		
		new UpdateChecker(main.getInstance(), 82149).getVersion(version -> {
	           if (!(main.getInstance().getDescription().getVersion().equalsIgnoreCase(version))) {
	        	   if(e.getPlayer().isOp()) {
		               Player p = (Player) e.getPlayer();
		               
		               p.sendMessage(Utils.chat(main.plugin3.getConfig().getString("prefix") + "&a New update is available for McFacts download it!"));
		           }
	           }
	      });
		
	}
	
}
