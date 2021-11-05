package de.rexlNico.Lobby.Listeners;

import de.rexlNico.Lobby.Methodes.Var;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerHider_Event
  implements Listener
{
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) || (e.getAction().equals(Action.LEFT_CLICK_AIR))) && 
      (p.getItemInHand() != null) && 
      (p.getItemInHand().getType().equals(Material.INK_SACK)) && (
      (p.getItemInHand().getItemMeta().getDisplayName().equals("§aAlle")) || (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Freunde")) || 
      (p.getItemInHand().getItemMeta().getDisplayName().equals("§4Keinen"))))
    {
    	
    	e.setCancelled(true);
      Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§6Playerhider");
      
      ItemStack i1 = new ItemStack(Material.INK_SACK, 1, (short)10);
      ItemMeta im1 = i1.getItemMeta();
      im1.setDisplayName("§aAlle Spieler sichtbar");
      i1.setItemMeta(im1);
      
      ItemStack i2 = new ItemStack(Material.INK_SACK, 1, (short)14);
      ItemMeta im2 = i2.getItemMeta();
      im2.setDisplayName("§6Nur Freunde sichtbar");
      i2.setItemMeta(im2);
      
      ItemStack i3 = new ItemStack(Material.INK_SACK, 1, (short)1);
      ItemMeta im3 = i3.getItemMeta();
      im3.setDisplayName("§4Keine Spieler sichtbar");
      i3.setItemMeta(im3);
      
      inv.setItem(0, i1);
      inv.setItem(1, i2);
      inv.setItem(2, i3);
      
      p.openInventory(inv);
    }
  }
  
  @EventHandler
  public void on(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    
    ItemStack i1 = new ItemStack(Material.INK_SACK, 1, (short)10);
    ItemMeta im1 = i1.getItemMeta();
    im1.setDisplayName("§aAlle");
    i1.setItemMeta(im1);
    
    ItemStack i2 = new ItemStack(Material.INK_SACK, 1, (short)14);
    ItemMeta im2 = i2.getItemMeta();
    im2.setDisplayName("§6Freunde");
    i2.setItemMeta(im2);
    
    ItemStack i3 = new ItemStack(Material.INK_SACK, 1, (short)1);
    ItemMeta im3 = i3.getItemMeta();
    im3.setDisplayName("§4Keinen");
    i3.setItemMeta(im3);
    if ((e.getCurrentItem().getType().equals(Material.INK_SACK)) && 
      (e.getInventory().getName().equals("§6Playerhider"))) {
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAlle Spieler sichtbar"))
      {
        e.setCancelled(true);
        p.sendMessage(Var.pr + "§aAlle Spieler sind nun sichtbar.");
        File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        cfg.set("PlayerHider", "alle");
        try
        {
          cfg.save(file);
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
        Alle(p);
        
        p.getInventory().setItem(8, i1);
        p.closeInventory();
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Nur Freunde sichtbar"))
      {
        e.setCancelled(true);
        p.sendMessage(Var.pr + "§6Alle deine Freunde sind nun sichtbar");
        File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        cfg.set("PlayerHider", "freunde");
        try
        {
          cfg.save(file);
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
        Freunde(p);
        
        p.getInventory().setItem(8, i2);
        p.closeInventory();
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Keine Spieler sichtbar"))
      {
        e.setCancelled(true);
        p.sendMessage(Var.pr + "§4Alle Spieler sind nun unsichtbar.");
        File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        cfg.set("PlayerHider", "nix");
        try
        {
          cfg.save(file);
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
        Keine(p);
        
        p.getInventory().setItem(8, i3);
        p.closeInventory();
      }
    }
  }
  
  public static void Freunde(Player p) {}
  
  public static void Alle(Player p)
  {
    for (Player a : Bukkit.getOnlinePlayers()) {
      if (p != a) {
        p.showPlayer(a);
      }
    }
  }
  
  public static void Keine(Player p)
  {
    for (Player a : Bukkit.getOnlinePlayers()) {
      if (p != a) {
        p.hidePlayer(a);
      }
    }
  }
}
