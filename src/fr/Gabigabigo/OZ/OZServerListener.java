package fr.Gabigabigo.OZ;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
//import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OZServerListener implements Listener
{
public static OZ plugin;

public OZServerListener(OZ instance)
{
  plugin = instance;
}

@EventHandler(priority=EventPriority.HIGHEST)
public void onCreatureSpawn(CreatureSpawnEvent event)
{
  EntityType c = event.getEntityType();

  if (!(c == EntityType.ZOMBIE)){
    event.setCancelled(true);}
 
}
@EventHandler(priority=EventPriority.HIGHEST)
public void onZombieSpawn(CreatureSpawnEvent event){
    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED,2147483647, 2));
}
/*@EventHandler(priority=EventPriority.HIGHEST)
public void onEntityCombust(EntityCombustEvent event)
{

    Entity combuster = event.getEntity();
    if (this.plugin.getMo(combuster))
      event.setCancelled(true); 
  }
*/

}