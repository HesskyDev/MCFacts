package me.Hessky.AdventurePlus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class adventuretips implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
        	sender.sendMessage(ChatColor.DARK_RED + "You are not a player!");
        	return true;
        }
        
        Player p = (Player) sender;
        p.sendMessage("Working on this");
        
        return false;
    }
}