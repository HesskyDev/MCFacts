package me.Hessky.McFacts.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class FactBookEvent implements Listener{
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		
		if(event.getItem()==null) return;
		if(event.getItem().getType()==null) return;
		if(!(event.getItem().getItemMeta().getEnchantLevel(Enchantment.BINDING_CURSE) == 252)) return;
	
		Player p = event.getPlayer();
		p.performCommand("facts");
	}
}
