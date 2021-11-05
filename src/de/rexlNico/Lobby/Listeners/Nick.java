package de.rexlNico.Lobby.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Nick
  implements Listener
{
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction().equals(Action.LEFT_CLICK_AIR)) || 
      (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || 
      (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) || 
      (e.getAction().equals(Action.RIGHT_CLICK_AIR))) && 
      (p.getItemInHand().getType().equals(Material.NAME_TAG)))
    {
    	
    	e.setCancelled(true);
      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      if (p.getItemInHand().getItemMeta().getDisplayName().equals("§7Autonick §cAus"))
      {
        ItemStack i12 = new ItemStack(Material.NAME_TAG);
        ItemMeta im12 = i12.getItemMeta();
        im12.setDisplayName("§7Autonick §aAn");
        i12.setItemMeta(im12);
        
        p.getInventory().setItem(4, i12);
        cfg.set("Nick", Boolean.valueOf(true));
        try
        {
          cfg.save(file);
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
      }
      else if (p.getItemInHand().getItemMeta().getDisplayName().equals("§7Autonick §aAn"))
      {
        ItemStack i12 = new ItemStack(Material.NAME_TAG);
        ItemMeta im12 = i12.getItemMeta();
        im12.setDisplayName("§7Autonick §cAus");
        i12.setItemMeta(im12);
        
        p.getInventory().setItem(4, i12);
        cfg.set("Nick", Boolean.valueOf(false));
        try
        {
          cfg.save(file);
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
      }
    }
  }
}
