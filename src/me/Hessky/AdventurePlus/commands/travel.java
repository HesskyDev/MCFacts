package me.Hessky.AdventurePlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class travel implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length == 1) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Please specify a player name!");
                }
                else {
                    final Location targetLoc = target.getLocation();
                    player.sendMessage(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Travelling...").toString());
                    player.teleport(targetLoc);
                    player.sendMessage(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("You travelled to ").append(args[0]).toString());
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Please specify a player name!");
            }
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "You are not a player!");
        }
        return false;
    }
}