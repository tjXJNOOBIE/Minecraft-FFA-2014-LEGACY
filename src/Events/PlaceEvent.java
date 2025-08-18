package Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener{
	
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		e.setCancelled(true);
		if(e.getBlock().getType() == Material.FIRE) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
		if(e.getBlock().getType() == Material.FIRE) {
			e.setCancelled(false);
		}
	}

}
