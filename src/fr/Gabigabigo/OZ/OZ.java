package fr.Gabigabigo.OZ;

import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class OZ extends JavaPlugin {

    public final OZServerListener EntityListener = new OZServerListener(this);
    protected OZLogger log;
    public static String name;
    public static String version;
    public static OZ plugin;

    @Override
    public void onLoad(){
        this.killCreature();
    }
    
    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.EntityListener, this);
        this.log = new OZLogger(this);

        this.killCreature();
    }
    
    private void killCreature(){
        //Replace al the entities by zombie
        for (World w : getServer().getWorlds()) {
            for (Entity ent : w.getEntities()) {
                if (ent.getType() != EntityType.PLAYER && ent.getType() != EntityType.ZOMBIE) {
                    w.spawnEntity(ent.getLocation(), EntityType.ZOMBIE);

                    //Destroy the old entity            
                    ent.remove();
                }
            }
        } 
    }
}
