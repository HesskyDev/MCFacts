package me.Hessky.McFacts.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Hessky.McFacts.utils.Utils;
import me.Hessky.McFacts.Main;

public class McFactsReload implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage(Utils.chat(Main.plugin3.getConfig().getString("consolewarn")));
			
			return true;
		}
		
		Player p = (Player) sender;
		
		
		if(!(p.hasPermission("mcfacts.reload"))){
			
			p.sendMessage(Utils.chat(Main.plugin3.getConfig().getString("prefix") + " &cSorry you don't have the \"mcfacts.reload\" permission!"));
			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 3.0F, 0.5F);
			
			return true;
		}
		
		Location loc = p.getLocation();
		
		p.sendMessage(Utils.chat(Main.plugin3.getConfig().getString("prefix") + " &aReloading config..."));
		Main.plugin3.reloadConfig();
		Main.plugin3.saveConfig();
		Main.plugin3.saveDefaultConfig();
			
		p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
		p.sendMessage(Utils.chat(Main.plugin3.getConfig().getString("prefix") + " &aConfig reloaded!"));
		
		return false;
	} 
	
}
