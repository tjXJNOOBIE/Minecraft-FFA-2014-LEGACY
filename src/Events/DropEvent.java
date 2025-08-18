package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener{ 
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		if(!player.hasPermission("na.build")) {
			e.setCancelled(true);
			return;
		}
			if(player.hasPermission("na.build")) {
				e.setCancelled(false);
				return;
			}
		}
			@EventHandler
			public void onBlockPLace(BlockPlaceEvent e) {
				Player player = e.getPlayer();
				if(!player.hasPermission("na.build")) {
					e.setCancelled(true);
					return;
				}
					if(player.hasPermission("na.build")) {
						e.setCancelled(false);
						return;
	}
			}
}
