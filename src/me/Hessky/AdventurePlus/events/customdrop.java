package me.Hessky.AdventurePlus.events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class customdrop implements Listener
{   
    @EventHandler
    public void mobDeath(final EntityDeathEvent event) {
    	//variables
        final LivingEntity entity = event.getEntity();
        final ItemStack tntDrop = new ItemStack(Material.TNT);
        final ItemMeta tntMeta = tntDrop.getItemMeta();
        final ArrayList<String> lore = new ArrayList<String>();
        tntMeta.setDisplayName(ChatColor.DARK_PURPLE + "Cosmic TNT");
        lore.add(new StringBuilder().append(ChatColor.WHITE).append(ChatColor.BOLD).append("Used by the aliens, very dangerous.").toString());
        tntMeta.setLore(lore);
        tntDrop.setItemMeta(tntMeta);
        final ItemStack boneDrop = new ItemStack(Material.SKELETON_SKULL);
        final ItemMeta boneMeta = boneDrop.getItemMeta();
        final ArrayList<String> boneLore = new ArrayList<String>();
        boneMeta.setDisplayName(ChatColor.GRAY + "Broken Skull");
        boneLore.add(new StringBuilder().append(ChatColor.WHITE).append(ChatColor.BOLD).append("Don't break the entire skull it's usefull.").toString());
        boneMeta.setLore(boneLore);
        boneDrop.setItemMeta(boneMeta);
        if (entity instanceof Creeper) {
            if ((int) (Math.random()*100) <= 5) {
                entity.getLocation().getWorld().dropItem(entity.getLocation(), tntDrop);
            }
        }
        else if (entity instanceof Skeleton) {
            if ((int) (Math.random()*100) <= 10) {
                entity.getLocation().getWorld().dropItem(entity.getLocation(), boneDrop);
            }
        }
        else if (entity instanceof Squid) {
            if ((int) (Math.random()*100) <= 5) {
                final ItemStack squidEye = new ItemStack(Material.ENDER_EYE);
                final ItemMeta squidEyeMeta = squidEye.getItemMeta();
                final ArrayList<String> squidEyeLore = new ArrayList<String>();
                squidEyeLore.add(new StringBuilder().append(ChatColor.WHITE).append(ChatColor.BOLD).append("Its alive, use it to enter a new world.").toString());
                squidEyeMeta.setDisplayName(ChatColor.DARK_GREEN + "Squid Eye");
                squidEyeMeta.setLore(squidEyeLore);
                squidEye.setItemMeta(squidEyeMeta);
                entity.getLocation().getWorld().dropItem(entity.getLocation(), squidEye);
            }
            if ((int) (Math.random()*100) >= 95) {
                final ItemStack squidDeadEye = new ItemStack(Material.ENDER_PEARL);
                final ItemMeta squidDeadEyeMeta = squidDeadEye.getItemMeta();
                final ArrayList<String> squidDeadEyeLore = new ArrayList<String>();
                squidDeadEyeLore.add(new StringBuilder().append(ChatColor.WHITE).append(ChatColor.BOLD).append("Dead squid eye, it's not very usefull.").toString());
                squidDeadEyeMeta.setDisplayName(ChatColor.DARK_AQUA + "Dead Squid Eye");
                squidDeadEyeMeta.setLore(squidDeadEyeLore);
                squidDeadEye.setItemMeta(squidDeadEyeMeta);
                entity.getLocation().getWorld().dropItem(entity.getLocation(), squidDeadEye);
            }
        }
        else if (entity instanceof Blaze) {
            if ((int) (Math.random()*100) == 1) {
                final ItemStack fireChesplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                final ItemMeta LeatherArmorMeta = fireChesplate.getItemMeta();
                final ArrayList<String> fireChespLore = new ArrayList<String>();
                fireChespLore.add(ChatColor.GOLD + "One of the most powerfull and rarest chesplates.");
                LeatherArmorMeta.setLore(fireChespLore);
                LeatherArmorMeta.setDisplayName(ChatColor.GOLD + "Fire Chesplate");
                LeatherArmorMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
                LeatherArmorMeta.addEnchant(Enchantment.PROTECTION_FIRE, 15, true);
                LeatherArmorMeta.addEnchant(Enchantment.THORNS, 7, true);
                LeatherArmorMeta.addEnchant(Enchantment.MENDING, 3, true);
                LeatherArmorMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                LeatherArmorMeta.setUnbreakable(true);
                fireChesplate.setItemMeta(LeatherArmorMeta);
                entity.getLocation().getWorld().dropItem(entity.getLocation(), fireChesplate);
            }
        }
        else if (entity instanceof Witch) {
            if ((int) (Math.random()*100) == 1) {
                final ItemStack witchHat = new ItemStack(Material.LEATHER_HELMET);
                final ItemMeta witchHatMeta = witchHat.getItemMeta();
                final ArrayList<String> witchHatLore = new ArrayList<String>();
                witchHatLore.add(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Magical and powerfull hat.").toString());
                witchHatMeta.setLore(witchHatLore);
                witchHatMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
                witchHatMeta.addEnchant(Enchantment.THORNS, 5, true);
                witchHatMeta.addEnchant(Enchantment.MENDING, 3, true);
                witchHatMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                witchHatMeta.setDisplayName(ChatColor.DARK_PURPLE + "Witch Hat");
                witchHat.setItemMeta(witchHatMeta);
                entity.getLocation().getWorld().dropItem(entity.getLocation(), witchHat);
            }
        }
    }
}
