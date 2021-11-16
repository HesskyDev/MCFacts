package me.Hessky.McFacts.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Hessky.McFacts.Main;
import me.Hessky.McFacts.utils.Utils;

public class Tiers implements CommandExecutor{
	
	private Main plugin;
	
	public Tiers(Main plugin){
		
		this.plugin = plugin;
		
		plugin.getCommand("Tiers").setExecutor(this);
	}
	
	@Override
	public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("consolewarn")));
			
			return true;
		}
		
		Player p = (Player) sender;
		Location ploc = p.getLocation();
		
		p.playSound(ploc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
		p.sendMessage(Utils.chat("&3&l| &c&lFacts Tier List &3&l|"));
		p.sendMessage(Utils.chat("&3&l| " + plugin.getConfig().getString("commoncolor") + "&a&lCommon - This color"));
		p.sendMessage(Utils.chat("&3&l| " + plugin.getConfig().getString("rarecolor") + "Rare - " + plugin.getConfig().getInt("rarechance") / 10 + "% chance"));
		p.sendMessage(Utils.chat("&3&l| " + plugin.getConfig().getString("epiccolor") + "Epic - " +  plugin.getConfig().getInt("epicchance") / 10 + "% chance"));
		p.sendMessage(Utils.chat("&3&l| " + plugin.getConfig().getString("legendarycolor") + "Legendary - "  +  plugin.getConfig().getInt("legendarychance") / 10 + "% chance"));
	
		return false;
	}
}
