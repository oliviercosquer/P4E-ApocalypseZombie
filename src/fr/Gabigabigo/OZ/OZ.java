package fr.Gabigabigo.OZ;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class OZ extends JavaPlugin{
	
	  public final OZServerListener EntityListener = new OZServerListener(this);
		protected OZLogger log;
		public static String name;
		public static String version;
		public static OZ plugin;
	 

	  public void onDisable()
	  {

	  }

	  public void onEnable()
	  {
		  PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(this.EntityListener,this);
			this.log = new OZLogger(this);
	  }
}
