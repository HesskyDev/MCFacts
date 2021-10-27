package me.Hessky.McFacts.commands;



import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Hessky.McFacts.Main;
import me.Hessky.McFacts.utils.Utils;


public class Facts implements CommandExecutor{
	
	private Main plugin;
	
	public Facts(Main plugin){
		
		this.plugin = plugin;
		
		plugin.getCommand("Facts").setExecutor(this);
	}
	
	Map<String, Long> cooldown = new HashMap<String, Long>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		//Checking if the sender is a player
		if(!(sender instanceof Player)) {
			
			//Only a player can execute the cmd warning
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("consolewarn")));
			
			return true;
		}
			
			Player p = (Player) sender;
			//Location for playSound
			Location ploc = p.getLocation();
			
			//COOLDOWN
			if(cooldown.containsKey(p.getName())) {
				
				if(cooldown.get(p.getName()) > System.currentTimeMillis()) {
					
					long timeleft = (cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " &4Coolodwn " + timeleft + " &4second(s)."));
					
					return true;
				}
			}
			
			cooldown.put(p.getName(), System.currentTimeMillis()+ plugin.getConfig().getInt("cooldown") * 1000);
			
			//Facts
			if(plugin.getConfig().getString("chatmessage").toLowerCase().contains("true")) {
				
				//Rare facts
				int randomnum = (int) (Math.random()*1000);
				
				if(randomnum <= plugin.getConfig().getInt("legendarychance")) {
					
					p.sendTitle(Utils.chat(plugin.getConfig().getString("legendarycolor") + "Legendary Fact"), "", 30, 70, 20);
					p.playSound(ploc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("legendarycolor") + plugin.getConfig().getList("legendaryfacts").get((int)(Math.random()*plugin.getConfig().getList("legendaryfacts").size()))));
					
					return true;
				
				}else {
					
					//Epic fact
					if(randomnum <= plugin.getConfig().getInt("epicchance")  + plugin.getConfig().getInt("legendarychance")) {
						
						p.sendTitle(Utils.chat(plugin.getConfig().getString("epiccolor") + "Epic Fact"), "", 30, 70, 20);
						p.playSound(ploc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("epiccolor") + plugin.getConfig().getList("epicfacts").get((int)(Math.random()*plugin.getConfig().getList("epicfacts").size()))));
						
						return true;
					
					}else {
						
						//Rare fact
						if(randomnum <= plugin.getConfig().getInt("rarechance") + plugin.getConfig().getInt("epicchance")){
							
							p.sendTitle(Utils.chat(plugin.getConfig().getString("rarecolor") + "Rare Fact"), "",30, 70, 20);
							p.playSound(ploc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
							p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("rarecolor") + plugin.getConfig().getList("rarefacts").get((int)(Math.random()*plugin.getConfig().getList("rarefacts").size()))));
							
							return true;
						
						}else {
							
							//Normal Fact
							p.playSound(ploc, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
							p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("commoncolor") +plugin.getConfig().getList("commonfacts").get((int)(Math.random()*plugin.getConfig().getList("commonfacts").size()))));
						}
					}
				}
					
			}
			
			return false;
	
	}
}
