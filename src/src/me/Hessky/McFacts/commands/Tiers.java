package me.Hessky.McFacts.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Hessky.McFacts.main;
import me.Hessky.McFacts.utils.Utils;

public class Tiers implements CommandExecutor{
	private main plugin;
	
	public Tiers(main plugin){
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
		
		p.playSound(ploc, Sound.BLOCK_DISPENSER_LAUNCH, 3.0F, 0.5F);
		p.sendMessage(Utils.chat("&3&l| &c&lFacts Tier List &3&l|"));
		p.sendMessage(Utils.chat("&3&l| &a&l Common - "+plugin.getConfig().getString("factcolor")+ "This Color &3&l|"));
		p.sendMessage(Utils.chat("&3&l| &1&l Rare - "+plugin.getConfig().getString("rarecolor")+ "This Color &3&l|"));
		p.sendMessage(Utils.chat("&3&l| &5&lEpic - "+plugin.getConfig().getString("epiccolor")+ "This Color &3&l|"));
		p.sendMessage(Utils.chat("&3&l| &e&lLegendary - "+plugin.getConfig().getString("legendarycolor")+ "This Color &3&l|"));
	
		return false;
	}
}
