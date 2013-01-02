package fr.Gabigabigo.OZ;

import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OZServerListener implements Listener {

    public static OZ plugin;

    public OZServerListener(OZ instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        EntityType entType = event.getEntityType();
        Entity ent = event.getEntity();
        World world = ent.getWorld();

        //If it's not a zombie, change the entity type by a zombie
        if (entType != EntityType.ZOMBIE) {

            //Spawn a new zombie at the ent location
            world.spawnEntity(ent.getLocation(), EntityType.ZOMBIE);
            //Destroy the old entity            
            ent.remove();
        }

    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onZombieSpawn(CreatureSpawnEvent event) {
        //Make zombie go faster
        event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 2));
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityDamage(EntityDamageEvent event) {
        EntityType entType = event.getEntityType();
        Entity ent = event.getEntity();

        //Cancel if zombie damaged by a fire tick
        if(entType == EntityType.ZOMBIE && event.getCause() == DamageCause.FIRE_TICK){
            event.setCancelled(true);
            ent.setFireTicks(0);
        }
    }
}