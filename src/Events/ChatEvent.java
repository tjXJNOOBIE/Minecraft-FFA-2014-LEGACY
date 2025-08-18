package Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener{
	
	
	
	
	
	
	
	@EventHandler
	 public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();

			if(player.hasPermission("chat.mod")) {
				e.setMessage(ChatColor.translateAlternateColorCodes('&',  e.getMessage()));
				e.setFormat(player.getDisplayName() + "§8: §f"+ e.getMessage());
				return;	
			}
			if(player.hasPermission("chat.novice")) {
				e.getPlayer().setDisplayName(player.getName() + "§b");
				e.setFormat(player.getDisplayName() + "§8: §f"+ e.getMessage());
				return;	
			}
	if(player.hasPermission("chat.pro")) {
		e.setFormat(player.getDisplayName() + "§8: §f"+ e.getMessage());
		return;
	}
	if(player.hasPermission("chat.master")) {
		e.setFormat(player.getDisplayName() + "§8: §f"+ e.getMessage());
		return;	
	}
	if(player.hasPermission("chat.member")) {
		e.getPlayer().setDisplayName("§7" + player.getName());
		player.setPlayerListName("§7" + player.getName());
		e.setFormat(player.getDisplayName() + "§8: §7"+ e.getMessage());
		return;	
	}

	if(player.hasPermission("chat.rouge")) {
		e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		e.setFormat(player.getDisplayName() + "§7: §f"+ e.getMessage());
		return;	
	}
	if(player.hasPermission("chat.gladiator")) {
		e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		e.setFormat(player.getDisplayName() + "§8: §f"+ e.getMessage());
		return;
	}



}
	
}
