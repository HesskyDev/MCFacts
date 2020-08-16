package me.Hessky.McFacts;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.Hessky.McFacts.commands.Facts;
import me.Hessky.McFacts.commands.Tiers;
import me.Hessky.McFacts.utils.Utils;


public class main extends JavaPlugin{
	
		
	
		@Override
		public void onEnable() {
			saveDefaultConfig();
			runnable();
			new Tiers(this);
			new Facts(this);
			System.out.println("\n\n --- MCFACTS PLUGIN ENABLED --- \n\n");
	}
	
		@Override
		public void onDisable() {
			System.out.println("\n\n --- MC FACTS PLUGIN DISABLED --- \n\n");
	}
	
	//Please ignore the bottom
		String[] rarefacts = {"A sheep has a 0.5% chance to spawn pink.", "If a creeper gets stuck in a cobweb, it will not blow up.", "The EnderDragons name is actually \"Jean\", as it was named by Notch.","Minecraft is bigger than Earth!", "You move faster underwater if the water is encased in something.", "One Minecraft day is equivalent to 20 minutes." ,"The Ghast mob of Minecraft is the second-largest mob in the game.", "Drinking milk or honey bottle can cure the poison.","GHASTS ARE VOICED BY A SLEEPING CAT.","THE ENDERMAN LANGUAGE IS ACTUALLY ENGLISH IN REVERSE (OR PITCHED DOWN)."
		};
		
		String[] epicfacts = {"Enderman always drop ender pearls if it is killed by an Iron Golem.", "When the game is paused, a hostile enderman will still shake.","Despite their lack of arms, creepers can climb ladders.", "The landscape of Minecraft is called Biomes.", "An arrow shot at primed TNT will come back at you.", "Shears don't take durability damage when destroying wool.","Creepers were actually meant to be pigs but they got encoded incorrectly.","All cows in Minecraft are female, since you can acquire milk from all cows."
		};
		String[] legendaryfacts =  {"Ghasts can't blow up cobblestone.","Lava pools are more common in taiga and snowy biomes.","Villagers will breed if there is a wooden door in their village.", "You can drag any mob with a fishing rod.", "Spiders are friendly during daytime or fully lit room.",  "It takes 10 minutes and 40 seconds to smelt a stack of anything.","Playing Minecraft improves the player's geometric skills."
		};
		String[] facts = {"THE FIRST VERSION OF MINECRAFT WAS CREATED IN JUST SIX DAYS.", "THE GAME’S FIRST NAME WAS \"CAVE GAME\"","If a player eats raw chicken while crouching, it will have a lower chance of \"food poisoning\".","Crafting table was once called \"workbench\".", "The first Enderman originally had green eyes.", "Today, players can find 128 strongholds.","Zombies are safe in the cobweb in the daytime.",  "You cannot see a player name tag through chests, even if the player is not sneaking.","Pumpkins are more rare than Diamonds.", "Weather happens around every 7 Minecraft days, which is 2 hours real time.","A bow at max power can destroy a boat and a minecart.", "Arrows shot through lava will cause fire damage.","Right clicking a mooshroom with a bowl gives you mushroom stew", "It\'s easier to catch fish in the rain",  "An an enraged spider who is damaged from falling or cactus will be neutral again.","Skeletons and zombies on soul sand won't burn in the day.","Sneaking effects you\'r reach distance.","Tamed wolves will attack you if you shoot yourself with an arrow.",  "If you throw an xp at a slab, you tend to get more xp.", "Using a tool for a different use than is intended will descrease durability by 2 points instead of one.", "A splash potion of harming will heal a skeleton.", "A splash potion of healing will harm an undead mob.", "Lava blocks in the nether can flow 7 blocks, when it only goes 4 in the overworld.", "Enderman will become passive again if it touches water.", "Iron Golems and wolves are the only mobs that can become hostile in peaceful mode.",
		};
		//Auto fact
		public void runnable() {
		new BukkitRunnable() {
			@Override
			public void run() {
				int randomnum = (int) (Math.random()*1000);
				//Legendary fact
				if(randomnum <= getConfig().getInt("legendarychance")) {
					Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("legendarycolor") + legendaryfacts[(int) (Math.random()* legendaryfacts.length)].toUpperCase()));
				}else {
					//Epic fact
					if(randomnum <= getConfig().getInt("epicchance")  + getConfig().getInt("legendarychance")) {
						Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("epiccolor") + epicfacts[(int) (Math.random()*epicfacts.length)].toUpperCase()));
					}else {
						//Rare fact
						if(randomnum <= getConfig().getInt("rarechance") + getConfig().getInt("epicchance")){
							Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("rarecolor") + rarefacts[(int) (Math.random()*rarefacts.length)].toUpperCase()));
						}else {
							//Normal Fact
							Bukkit.broadcastMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("factcolor") + facts[(int) (Math.random()*facts.length)].toUpperCase()));
						}
					}
				}
					
			}
		}.runTaskTimerAsynchronously(this, 0, getConfig().getInt("autofactTime")*20);
	}
	
}
