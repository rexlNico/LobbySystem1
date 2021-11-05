package de.rexlNico.Lobby.Listeners;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyWechsler
  implements Listener
{
	
	private ByteArrayOutputStream b = new ByteArrayOutputStream();
	private DataOutputStream out = new DataOutputStream(b);
	
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || 
      (e.getAction().equals(Action.RIGHT_CLICK_AIR)) || 
      (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) || 
      (e.getAction().equals(Action.LEFT_CLICK_AIR))) && 
      (p.getItemInHand() != null) && 
      (p.getItemInHand().getType().equals(Material.NETHER_STAR)))
    {
    	
    	e.setCancelled(true);
    	
      Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§bLobbywechsler");
      
      ItemStack i1 = new ItemStack(Material.NETHER_STAR);
      ItemMeta im1 = i1.getItemMeta();
      im1.setDisplayName("§bLobby §e1");
      i1.setItemMeta(im1);
      
      ItemStack i2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta im2 = i2.getItemMeta();
      im2.setDisplayName("");
      i2.setItemMeta(im2);
      
      ItemStack i3 = new ItemStack(Material.NETHER_STAR);
      ItemMeta im3 = i3.getItemMeta();
      im3.setDisplayName("§bLobby §e2");
      i3.setItemMeta(im3);
      
      ItemStack i4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta im4 = i4.getItemMeta();
      im4.setDisplayName("");
      i4.setItemMeta(im4);
      
      ItemStack i5 = new ItemStack(Material.TNT);
      ItemMeta im5 = i5.getItemMeta();
      im5.setDisplayName("§4Silent Hub");
      i5.setItemMeta(im5);
      
      inv.setItem(0, i1);
      inv.setItem(1, i2);
      inv.setItem(2, i3);
      inv.setItem(3, i4);
      inv.setItem(4, i5);
      
      p.openInventory(inv);
      p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
    }
  }
  
  @EventHandler
  public void on(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equals("§bLobbywechsler"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType().equals(Material.TNT)) {
        try {
			shub(p);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      } else if (e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bLobby §e1")) {
          try {
			lobby1(p);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bLobby §e2")) {
          try {
			lobby2(p);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
      }
    }
  }
  
  public void shub(Player p) throws IOException
  {
	  
	  out.writeUTF("Connect");
	  out.writeUTF("Silenthun-1");
    p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
  }
  
  public void lobby1(Player p) throws IOException
  {
	  
	  out.writeUTF("Connect");
	  out.writeUTF("Lobby-1");
    p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
  }
  
  public void lobby2(Player p) throws IOException
  {
	  
	  out.writeUTF("Connect");
	  out.writeUTF("Lobby-2");
    p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
  }
}
