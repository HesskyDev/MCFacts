package me.Hessky.McFacts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.McFacts.utils.Constants;

public class FactBookEvent implements Listener{
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		
		if(event.getItem()==null) return;
		if(event.getItem().getType()==null) return;
		if(!(event.getItem().getItemMeta().getPersistentDataContainer().has(Constants.FACT_BOOK, PersistentDataType.STRING))) return;
	
		Player p = event.getPlayer();
		p.performCommand("facts");
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(Constants.FACT_BOOK, PersistentDataType.STRING)) {
			e.setCancelled(true);
		}
	}
}
