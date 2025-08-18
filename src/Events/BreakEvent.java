package Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener{
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		if(e.getBlock().getType()==Material.GRASS) {
			player.teleport(player.getLocation());
			player.damage(10);
			player.sendMessage("§4§lNA§c> §c§lNEVER §cBlock glitch in your life!");
			player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
			
		}
	}

}
