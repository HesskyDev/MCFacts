package me.Hessky.AdventurePlus.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class superzombie implements Listener
{
    @EventHandler
    public void creatureSpawn(final CreatureSpawnEvent event) {
        if ((int) (Math.random()*100) == 2 && event.getEntityType() == EntityType.ZOMBIE) {
            final Zombie zombie = (Zombie)event.getEntity();
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 2));
        }
    }
}