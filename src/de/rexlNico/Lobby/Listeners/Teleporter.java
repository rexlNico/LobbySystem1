package de.rexlNico.Lobby.Listeners;

import de.rexlNico.Lobby.Commands.SetTeleporterSpawns;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Teleporter
  implements Listener
{
  public void setItem(Inventory inv, Material item, String name, int Slotvon1)
  {
    ItemStack i12 = new ItemStack(item);
    ItemMeta im12 = i12.getItemMeta();
    im12.setDisplayName(name);
    i12.setItemMeta(im12);
    
    inv.setItem(Slotvon1 - 1, i12);
  }
  
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) || (e.getAction().equals(Action.LEFT_CLICK_AIR))) && 
      (p.getItemInHand() != null) && 
      (p.getItemInHand().getType().equals(Material.WORKBENCH)) && (p.getItemInHand().getItemMeta().getDisplayName().equals("§bTeleporter")))
    {
      Inventory inv = Bukkit.createInventory(null, 45, "§bTeleporter");
      
      e.setCancelled(true);
      
      setItem(inv, Material.CHEST, "§5§lPoinWars", 4);
      setItem(inv, Material.EYE_OF_ENDER, "§6§lSpawn", 23);
      setItem(inv, Material.SKULL_ITEM, "§b§lrexlUnity", 6);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 11);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 17);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 29);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 35);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 40);
      setItem(inv, Material.BARRIER, "§c§lHast du eine idee", 42);
      
      p.openInventory(inv);
      p.playSound(p.getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
    }
  }
  
  @EventHandler
  public void on(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equals("§bTeleporter")) {
    	
    	e.setCancelled(true);
    	
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lPoinWars")) {
        SetTeleporterSpawns.tpToModus(p, "PoinWars");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lSpawn")) {
        SetTeleporterSpawns.tpToModus(p, "Spawn");
      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lrexlUnity")) {
        SetTeleporterSpawns.tpToModus(p, "rexlUnity");
      }
    }
  }
}
