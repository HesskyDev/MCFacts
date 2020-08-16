package me.Hessky.McFacts.commands;



import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Hessky.McFacts.main;
import me.Hessky.McFacts.utils.Utils;


public class Facts implements CommandExecutor{
	
	private main plugin;
	
	public Facts(main plugin){
		this.plugin = plugin;
		
		plugin.getCommand("Facts").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//facts below
		
		String[] rarefacts = {
				"A sheep has a 0.5% chance to spawn pink.", "If a creeper gets stuck in a cobweb, it will not blow up.", "The EnderDragons name is actually \"Jean\", as it was named by Notch.",
				"Minecraft is bigger than Earth!", "You move faster underwater if the water is encased in something.", "One Minecraft day is equivalent to 20 minutes." ,
				"The Ghast mob of Minecraft is the second-largest mob in the game.", "Drinking milk or honey bottle can cure the poison.",
				"GHASTS ARE VOICED BY A SLEEPING CAT.","THE ENDERMAN LANGUAGE IS ACTUALLY ENGLISH IN REVERSE (OR PITCHED DOWN)."
		};
		
		String[] epicfacts = {
				"Enderman always drop ender pearls if it is killed by an Iron Golem.", "When the game is paused, a hostile enderman will still shake.",
				"Despite their lack of arms, creepers can climb ladders.", "The landscape of Minecraft is called Biomes.", "An arrow shot at primed TNT will come back at you.", "Shears don't take durability damage when destroying wool.",
				"Creepers were actually meant to be pigs but they got encoded incorrectly.","All cows in Minecraft are female, since you can acquire milk from all cows."
		};
		String[] legendaryfacts =  {
				"Ghasts can't blow up cobblestone.","Lava pools are more common in taiga and snowy biomes.","Villagers will breed if there is a wooden door in their village.", 
				"You can drag any mob with a fishing rod.", "Spiders are friendly during daytime or fully lit room.",  "It takes 10 minutes and 40 seconds to smelt a stack of anything.",
				"Playing Minecraft improves the player's geometric skills."
		};
		String[] facts = {"THE FIRST VERSION OF MINECRAFT WAS CREATED IN JUST SIX DAYS.", "THE GAME’S FIRST NAME WAS \"CAVE GAME\"",
				"If a player eats raw chicken while crouching, it will have a lower chance of \"food poisoning\".",
				"Crafting table was once called \"workbench\".", "The first Enderman originally had green eyes.", "Today, players can find 128 strongholds.",
				"Zombies are safe in the cobweb in the daytime.",  "You cannot see a player name tag through chests, even if the player is not sneaking.",
				"Pumpkins are more rare than Diamonds.", "Weather happens around every 7 Minecraft days, which is 2 hours real time.",
				"A bow at max power can destroy a boat and a minecart.", "Arrows shot through lava will cause fire damage.",
				"Right clicking a mooshroom with a bowl gives you mushroom stew", "It\'s easier to catch fish in the rain",  
				"An an enraged spider who is damaged from falling or cactus will be neutral again.","Skeletons and zombies on soul sand won't burn in the day.","Sneaking effects you reach distance.",
				"Tamed wolves will attack you if you shoot yourself with an arrow.",  "If you throw an xp at a slab, you tend to get more xp.", 
				"Using a tool for a different use than is intended will descrease durability by 2 points instead of one.", "A splash potion of harming will heal a skeleton.", "A splash potion of healing will harm an undead mob.", 
				"Lava blocks in the nether can flow 7 blocks, when it only goes 4 in the overworld.", "Enderman will become passive again if it touches water.", "Iron Golems and wolves are the only mobs that can become hostile in peaceful mode.",
				 };
		
		//Checking if the sender is a player
		if(!(sender instanceof Player)) {
			//Only a player can execute the cmd warning
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("consolewarn")));
			return true;
		}
		
			Player p = (Player) sender;
			//Location for playSound
			Location ploc = p.getLocation();
			//Facts
			if(plugin.getConfig().getBoolean("chatmessage")) {
				//Rare facts
				int randomnum = (int) (Math.random()*1000);
				if(randomnum <= plugin.getConfig().getInt("legendarychance")) {
					p.sendTitle(Utils.chat(plugin.getConfig().getString("legendarycolor") + "Legendary Fact"), "", 30, 70, 20);
					p.playSound(ploc, Sound.BLOCK_DISPENSER_LAUNCH, 3.0F, 0.5F);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("legendarycolor") + legendaryfacts[(int) (Math.random()* legendaryfacts.length)].toUpperCase()));
					return true;
				}else {
					//Epic fact
					if(randomnum <= plugin.getConfig().getInt("epicchance")  + plugin.getConfig().getInt("legendarychance")) {
						p.sendTitle(Utils.chat(plugin.getConfig().getString("epiccolor") + "Epic Fact"), "", 30, 70, 20);
						p.playSound(ploc, Sound.BLOCK_DISPENSER_LAUNCH, 3.0F, 0.5F);
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("epiccolor") + epicfacts[(int) (Math.random()*epicfacts.length)].toUpperCase()));
						return true;
					}else {
						//Rare fact
						if(randomnum <= plugin.getConfig().getInt("rarechance") + plugin.getConfig().getInt("epicchance")){
							p.sendTitle(Utils.chat(plugin.getConfig().getString("rarecolor") + "Rare Fact"), "",30, 70, 20);
							p.playSound(ploc, Sound.BLOCK_DISPENSER_LAUNCH, 3.0F, 0.5F);
							p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("rarecolor") + rarefacts[(int) (Math.random()*rarefacts.length)].toUpperCase()));
							return true;
						}else {
							//Normal Fact
							p.playSound(ploc, Sound.BLOCK_DISPENSER_FAIL, 3.0F, 0.5F);
							p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("factcolor") + facts[(int) (Math.random()*facts.length)].toUpperCase()));
						}
					}
				}
					
			}
			return false;
	
	}
}
