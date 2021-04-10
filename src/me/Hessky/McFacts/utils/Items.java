package me.Hessky.McFacts.utils;

import java.util.ArrayList;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	@Deprecated
	public static ItemStack factbook() {
		String value = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmZTY1MDViYzg0MGFiZmQ4NjY2MjYxMDE3ZWMyMGE2ODQ2ODU2MWJjM2NmMmZhZDYzOWE0ZWM5NDc4OWZhMCJ9fX0=";
		ItemStack factbook = new ItemStack(SkullMaker.itemWithBase64(SkullMaker.createSkull(),value)).clone();
		ItemMeta meta = factbook.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add(Utils.chat("&6Interact with this to get a random fact."));
		
		meta.addEnchant(Enchantment.BINDING_CURSE, 252, true);
		
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setDisplayName(Utils.chat("&6&lBook of Facts"));
		meta.setLore(lore);
		factbook.setItemMeta(meta);
		
		return factbook;
	}
	
}
