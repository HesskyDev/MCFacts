package me.Hessky.McFacts.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Hessky.McFacts.Main;
import me.Hessky.McFacts.utils.UpdateChecker;
import me.Hessky.McFacts.utils.Utils;

public class UpdateCheckerJoin implements Listener{

	
	@EventHandler
	public void pJoin(PlayerJoinEvent e) {
		
		new UpdateChecker(Main.getInstance(), 82149).getVersion(version -> {
	           if (!(Main.getInstance().getDescription().getVersion().equalsIgnoreCase(version))) {
	        	   if(e.getPlayer().isOp()) {
		               Player p = (Player) e.getPlayer();
		               p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
		               p.sendMessage(Utils.chat(Main.plugin3.getConfig().getString("prefix") + "&a New update is available for McFacts, download it!"));
		           }
	           }
	      });
		
	}
	
}
