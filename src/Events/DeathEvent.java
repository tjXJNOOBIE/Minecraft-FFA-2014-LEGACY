package Events;


import java.util.ArrayList;
import java.util.List;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dev.tjxjnoobie.ffa.FFA;

public class DeathEvent implements Listener {
	
	
	List<String> kill = new ArrayList<String>();
	List<String> pvplog = new ArrayList<String>();
	FFA plugin;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
	
		Player p = e.getEntity().getPlayer();
		Player k = e.getEntity().getKiller();
		ItemStack head = new ItemStack(Material.FLINT);

		e.getDrops().clear();
		k.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120, 1));
		k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
		k.getInventory().setItem(5, head);
		e.setDeathMessage("�7"+p.getDisplayName() + "�c was slain by�7 " + k.getDisplayName());
		if(k.getItemInHand().getType() ==  Material.BOW) {
			e.setDeathMessage("�7"+p.getDisplayName() + "�c was shot by " + "�7"+k.getDisplayName());
			BarAPI.setMessage("�7"+p.getDisplayName() + "�c was shot by�7 " + k.getDisplayName());
			Bukkit.dispatchCommand(k, "ks add " + k.getName() + " 1");
			if(k.hasPermission("na.rogue")) {
				k.playEffect(k.getLocation(), Effect.ENDER_SIGNAL, 0); 
			}
			

				
		
		}
		
	}
@EventHandler
public void onRespawn(PlayerRespawnEvent e1) {
	 Player player = e1.getPlayer();
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
	ItemMeta im = fire.getItemMeta();
	ItemMeta im1 = Sword.getItemMeta();
	ItemMeta im2 = Rod.getItemMeta();
	ItemMeta im3 = Arrow.getItemMeta();
	ItemMeta im4 = Bow.getItemMeta();
	im.setDisplayName("�6�lF&S");
	im1.setDisplayName("�6�lSword of Hope");
	im2.setDisplayName("�6�lLucky Rod");
	im4.setDisplayName("�6�lBow");
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
	im.setDisplayName("�6�lF&S");
	im.setDisplayName("�6�lPerson Burner");
	im1.setDisplayName("�6�lSword of Hope");
	im2.setDisplayName("�6�lLucky Rod");
	im4.setDisplayName("�6�lBow");
	
}


@EventHandler
public void onBurn(BlockBurnEvent e) {
	e.setCancelled(true);
}
@EventHandler
public void onDeath3(PlayerDeathEvent e) {
	for(Player ap : Bukkit.getOnlinePlayers()) {
	Player p = e.getEntity().getPlayer();
	Player k = e.getEntity().getKiller();
	World w = k.getWorld();
	if(k.hasPermission("na.rogue")) {
		BarAPI.setMessage("�c�k�l;;�f " + p.getDisplayName() + " �cwas �c�lMURDERED �cby " + k.getDisplayName()+ "�c�k�l;;");
		e.setDeathMessage( "�c�k�l;;�f " + "�7"+p.getDisplayName() + "�c was slain by�7 " + k.getDisplayName() +" �c�k�l;;�f" );
		ap.playSound(k.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		w.playSound(k.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		if(k.getItemInHand().getType() == Material.BOW) {
			BarAPI.setMessage("�c�k�l;;�f " + p.getDisplayName() + " �cwas �c�lSHOT �cby " + k.getDisplayName()+ "�c�k�l;;");
			ap.playSound(k.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
			e.setDeathMessage("�c�k�l;;�f"+p.getDisplayName() + "�c was KATNISSED by�7 " + k.getDisplayName() + "�c�k�l");
			w.playSound(k.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);


		}
	}
	if(k.hasPermission("na.member")) {
		ap.playSound(k.getLocation(), Sound.AMBIENCE_THUNDER, 10, 10);
		BarAPI.setMessage(p.getDisplayName() + " �cwas slain �cby " + k.getDisplayName());
	}
	}
	}
}




