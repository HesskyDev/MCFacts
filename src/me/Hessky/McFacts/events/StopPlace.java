package me.Hessky.McFacts.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.McFacts.utils.Constants;

public class StopPlace implements Listener{
	
	@Deprecated
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInHand().getItemMeta().getPersistentDataContainer().has(Constants.FACT_BOOK, PersistentDataType.STRING)) {
			
			e.setCancelled(true);
		}
		
			if(p.getInventory().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.BINDING_CURSE) == 252) {
				
				e.setCancelled(true);
			}
	}
}
