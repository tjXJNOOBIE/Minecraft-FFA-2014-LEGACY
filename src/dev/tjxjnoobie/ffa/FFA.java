package dev.tjxjnoobie.ffa;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Events.BreakEvent;
import Events.ChatEvent;
import Events.DeathEvent;
import Events.DropEvent;
import Events.FoodEvent;
import Events.JoinEvent;
import Events.PlaceEvent;
import Events.QuitEvent;
import Events.WeatherEvent;

public class FFA extends JavaPlugin implements Listener {
	
	PluginManager pm = getServer().getPluginManager();
	public static FFA instance;
	
	@Override
	public void onEnable() {
		createStats();
		pm.registerEvents(new DeathEvent(), this);
		pm.registerEvents(new DropEvent(), this);
		pm.registerEvents(new FoodEvent(),  this);
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new PlaceEvent(), this);
		pm.registerEvents(new QuitEvent(), this);
		pm.registerEvents(new WeatherEvent(), this);
		pm.registerEvents(new ChatEvent(), this);
		pm.registerEvents(new BreakEvent(), this);
		pm.registerEvents(this, this);
		
		
	}
	
	@Override
	public void onDisable() {
		saveBalances();
		
	}

	
	public void createStats() {
		try {
			if(!getDataFolder().exists());
		getDataFolder().mkdirs();
		File file = new File (getDataFolder(), "stats.yml");
		if(!file.exists()) {
		getLogger().info("No stats file found! Creating...");
		file.createNewFile();
		saveConfig();
		
		}else {
			getLogger().info("Loading stats folder...");
		}

	} catch (Exception e) {
		e.printStackTrace();
		
	}
	}
    private static FFA plugin;

    {
        plugin = instance;
    }

    public static HashMap<String, Double> bal = new HashMap<>(); // {PlayerName, Balance}

    public static void setBalance(String player, double amount)
    {
        bal.put(player, amount);
    }

    public static Double getBalance(String player)
    {
        return bal.get(player);
    }

    public static boolean hasAccount(String player)
    {
        return bal.containsKey(player);
    }

    public static HashMap<String, Double> getBalanceMap()
    {
        return  bal;
    }

    public static FFA getPlugin()
    {
        return plugin;
    }
    public static void addBalance(String player, double amount) 
    {
        bal.put(player, amount);
    }



public static void saveBalances()
{
    for(String p : FFA.getBalanceMap().keySet())
    {
        plugin.getConfig().set("balance."+p, FFA.getBalanceMap().get(p));
    }
    plugin.saveConfig();
}

public static void loadBalances()
{
    if(!plugin.getConfig().contains("balance")) return;
    for(String s : plugin.getConfig().getConfigurationSection("balance").getKeys(false))
    {
        FFA.setBalance(s, plugin.getConfig().getDouble("balance."+s));
    }
}
@EventHandler
public void onFireBurn(BlockIgniteEvent e) {
	final ItemStack fire = new ItemStack(Material.FIRE);
	Block block = e.getBlock();
	 final Block ignited = block.getLocation().subtract(0.0D, 0.0D, 0.0D).getBlock();		
	

Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
	public void run() {
		ignited.breakNaturally(fire);
	}
}, 140L); {
	
}
	}

}
    	

    

	


