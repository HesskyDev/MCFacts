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

public class Facts implements CommandExecutor {

    private final Main plugin;
    private final Map<String, Long> cooldown = new HashMap<>();

    public Facts(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("Facts").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("consolewarn")));
            return true;
        }

        Player player = (Player) sender;
        Location playerLocation = player.getLocation();

        if (!checkCooldown(player)) {
            return true;
        }

        if (plugin.getConfig().getString("chatmessage").equalsIgnoreCase("true")) {
            sendRandomFact(player, playerLocation);
        }

        return true;
    }

    private boolean checkCooldown(Player player) {
        long currentTime = System.currentTimeMillis();
        if (cooldown.containsKey(player.getName())) {
            long timeLeft = (cooldown.get(player.getName()) - currentTime) / 1000;
            if (timeLeft > 0) {
                player.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " &4Cooldown: " + timeLeft + " second(s)."));
                return false;
            }
        }

        if (!(player.hasPermission("op") || player.hasPermission("mcfacts.cooldown"))) {
            cooldown.put(player.getName(), currentTime + plugin.getConfig().getInt("cooldown") * 1000);
        }
        return true;
    }

    private void sendRandomFact(Player player, Location location) {
        int randomNum = (int) (Math.random() * 1000);

        if (sendFact(player, location, "legendary", randomNum <= plugin.getConfig().getInt("legendarychance"))) return;
        if (sendFact(player, location, "epic", randomNum <= plugin.getConfig().getInt("epicchance") + plugin.getConfig().getInt("legendarychance"))) return;
        if (sendFact(player, location, "rare", randomNum <= plugin.getConfig().getInt("rarechance") + plugin.getConfig().getInt("epicchance"))) return;

        // Common fact as fallback
        sendFactMessage(player, "commoncolor", "commonfacts");
        playSound(location);
    }

    private boolean sendFact(Player player, Location location, String rarity, boolean condition) {
        if (condition) {
            player.sendTitle(Utils.chat(plugin.getConfig().getString(rarity + "color") + capitalize(rarity) + " Fact"), "", 30, 70, 20);
            sendFactMessage(player, rarity + "color", rarity + "facts");
            playSound(location);
            return true;
        }
        return false;
    }

    private void sendFactMessage(Player player, String colorKey, String factKey) {
        player.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString(colorKey)
                + plugin.getConfig().getList(factKey).get((int) (Math.random() * plugin.getConfig().getList(factKey).size()))));
    }

    private void playSound(Location location) {
        location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
