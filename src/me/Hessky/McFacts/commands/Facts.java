package me.Hessky.McFacts.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Facts implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//facts below
		String[] facts = {"THE FIRST VERSION OF MINECRAFT WAS CREATED IN JUST SIX DAYS.", "THE GAME’S FIRST NAME WAS \"CAVE GAME\""
				,"THE ENDERMAN LANGUAGE IS ACTUALLY ENGLISH IN REVERSE (OR PITCHED DOWN).", "GHASTS ARE VOICED BY A SLEEPING CAT.", 
				"Despite their lack of arms, creepers can climb ladders.", "The landscape of Minecraft is called Biomes.", 
				"Playing Minecraft improves the player's geometric skills.", "One Minecraft day is equivalent to 20 minutes." ,
				"The Ghast mob of Minecraft is the second-largest mob in the game.", "Drinking milk or honey bottle can cure the poison.",
				"If a player eats raw chicken while crouching, it will have a lower chance of \"food poisoning\".",
				"Crafting table was once called \"workbench\".", "The first Enderman originally had green eyes.", "Today, players can find 128 strongholds.",
				"Zombies are safe in the cobweb in the daytime.", "Minecraft is bigger than Earth!", "You cannot see a player name tag through chests, even if the player is not sneaking.",
				"Creepers were actually meant to be pigs but they got encoded incorrectly.", "A sheep has a 0.5% chance to spawn pink.", "The EnderDragons name is actually \"Jean\", as it was named by Notch.",
				"If a creeper gets stuck in a cobweb, it will not blow up.", "All cows in Minecraft are female, since you can acquire milk from all cows.",
				"Pumpkins are more rare than Diamonds.", "Weather happens around every 7 Minecraft days, which is 2 hours real time",
				"A bow at max power can destroy a boat and a minecart​.", "Arrows shot through lava will cause fire damage​.",
				"Right clicking a mooshroom with a bowl gives you mushroom stew​", "It\'s easier to catch fish in the rain​", "You can drag any mob with a fishing rod.",
				"Enderman always drop ender pearls if it is killed by an Iron Golem​.", "Spiders are friendly during daytime or fully lit room​.", "It takes 10 minutes and 40 seconds to smelt a stack of anything​.",
				"An an enraged spider who is damaged from falling or cactus will be neutral again​.","Skeletons and zombies on soul sand won't burn in the day​.","Sneaking effects you reach distance​.",
				"Tamed wolves will attack you if you shoot yourself with an arrow​.", "Shears don't take durability damage when destroying wool​.", "If you throw an xp at a slab, you tend to get more xp​.", 
				"Using a tool for a different use than is intended will descrease durability by 2 points instead of one​.", "A splash potion of harming will heal a skeleton​.", "A splash potion of healing will harm a skeleton.​", 
				"Lava blocks in the nether can flow 7 blocks, when it only goes 4 in the overworld​.", "Enderman will become passive again if it touches water​.", "Iron Golems and wolves are the only mobs that can become hostile in peaceful mode​.",
				"When the game is paused, a hostile enderman will still shake​.", "Villagers will breed if there is a wooden door in their village​.", "Lava pools are more common in taiga and snowy biomes​.",
				"You move faster underwater if the water is encased in something​.", "An arrow shot at primed TNT will come back at you​.", "Ghasts can't blow up cobblestone​."
				};
		
		//Checking if the sender is a player
		if(sender instanceof Player) {
			Player p = (Player) sender;
			//Location for playSound
			Location loc = p.getLocation();
			//Sending an random fact and sound
			p.playSound(loc, Sound.BLOCK_DISPENSER_FAIL, 3.0F, 0.5F);
			p.sendMessage( ChatColor.GOLD + "" + ChatColor.BOLD + "MCF: " + ChatColor.GREEN + "" + ChatColor.BOLD + "" + facts[(int) (Math.random()*facts.length)].toUpperCase());
		}else {
			//Only a player can execute the cmd warning
			sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Only a player can execute this command!");
		}
		return false;
	}
	
}
