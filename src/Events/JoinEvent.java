package Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import dev.tjxjnoobie.ffa.FFA;

public class JoinEvent implements Listener {
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
	
	ItemStack Sword = new ItemStack(Material.IRON_SWORD,1 );
	ItemStack Rod = new ItemStack(Material.FISHING_ROD, 1);
	ItemStack Bow = new ItemStack(Material.BOW, 1);
	ItemStack Arrow = new ItemStack(Material.ARROW, 24);
	ItemStack IronH = new ItemStack(Material.IRON_HELMET, 1);
	ItemStack IronC = new ItemStack(Material.IRON_CHESTPLATE, 1);
	ItemStack IronL = new ItemStack(Material.IRON_LEGGINGS, 1);
	ItemStack IronB = new ItemStack(Material.IRON_BOOTS, 1);
	ItemStack fire = new ItemStack(Material.FIREBALL, 3);
	PlayerInventory i = player.getInventory();
	player.getInventory().clear();
	e.setJoinMessage(null);
	player.setGameMode(GameMode.SURVIVAL);
	player.sendMessage("§6§n                                                                              ");
	player.sendMessage("");
	player.sendMessage("§6§lNA§f> §6Gamemode§f: §6FFA" );
	player.sendMessage("§6§lNA§f> §6Plugin Creator§f: §2tjXJNOOBIE");
	player.sendMessage("§6§lNA§f> §6Map Creator§f: §5IAmMicLovin101§f & §5TropicPvP ");
	player.sendMessage("§6§n                                                                              ");
	player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 10);
	ItemMeta im = fire.getItemMeta();
	ItemMeta im1 = Sword.getItemMeta();
	ItemMeta im2 = Rod.getItemMeta();
	ItemMeta im3 = Arrow.getItemMeta();
	ItemMeta im4 = Bow.getItemMeta();
	im.setDisplayName("§6§lF&S");
	im1.setDisplayName("§6§lSword of Hope");
	im2.setDisplayName("§6§lLucky Rod");
	im4.setDisplayName("§6§lBow");
	fire.setItemMeta(im);
	Sword.setItemMeta(im1);
	Rod.setItemMeta(im2);
	Arrow.setItemMeta(im3);
	Bow.setItemMeta(im4);
	Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 10000);
	i.setItem(0, Sword);
	i.setItem(1, Rod);
	i.setItem(2, Bow);
	i.setItem(8, fire);
	i.setItem(7, Arrow);
	i.setHelmet(IronH);
	i.setChestplate(IronC);
	i.setLeggings(IronL);
	i.setBoots(IronB);
	im.setDisplayName("§6§lF&S");
	im1.setDisplayName("§6§lSword of Hope");
	im2.setDisplayName("§6§lLucky Rod");
	im4.setDisplayName("§6§lBow");
    if(FFA.hasAccount(e.getPlayer().getName())) return;
    FFA.setBalance(e.getPlayer().getName(), 0D);
	}

	
	@EventHandler
	public void onJoin2(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		player.teleport(Bukkit.getWorld("world").getSpawnLocation());
		
	}
}

