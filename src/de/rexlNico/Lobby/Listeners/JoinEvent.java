package de.rexlNico.Lobby.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.rexlNico.Lobby.Methodes.ProfileApi;
import net.minecraft.server.v1_8_R3.ItemSkull;

public class JoinEvent
  implements Listener
{
	
	private ProfileApi api = new ProfileApi();
	
  @SuppressWarnings("static-access")
@EventHandler
  public void on(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    e.setJoinMessage(null);
    
    p.getInventory().clear();
    
    File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (cfg.getString("PlayerHider") == null)
    {
      cfg.set("PlayerHider", "alle");
      try
      {
        cfg.save(file);
      }
      catch (IOException e1)
      {
        e1.printStackTrace();
      }
      
      api.setGewonnen("PoinWars", p, 0);
      api.setKills("PoinWars", p, 0);
      api.setPlayedGames("PoinWars", p, 0);
      api.setTode("PoinWars", p, 0);
      api.setGewonnen("nix", p, 0);
      api.setKills("nix", p, 0);
      api.setPlayedGames("nix", p, 0);
      api.setTode("nix", p, 0);
      
    }
    ItemStack i1 = new ItemStack(Material.NETHER_STAR);
    ItemMeta im1 = i1.getItemMeta();
    im1.setDisplayName("§bLobbywechsler");
    i1.setItemMeta(im1);
    
    ItemStack i2 = new ItemStack(Material.WORKBENCH);
    ItemMeta im2 = i2.getItemMeta();
    im2.setDisplayName("§bTeleporter");
    i2.setItemMeta(im2);
    
    ItemStack i3 = new ItemStack(Material.SKULL_ITEM,1,(short)3);
    ItemMeta im3 = i3.getItemMeta();
    im3.setDisplayName("§dProfil");
    i3.setItemMeta(im3);
    SkullMeta sm = (SkullMeta) i3.getItemMeta();
    sm.setOwner(p.getName());
    i3.setItemMeta(sm);
    
    
    p.getInventory().setItem(2, i1);
    p.getInventory().setItem(0, i2);
    p.getInventory().setItem(6, i3);
    if (p.hasPermission("nicktool")) {
      if (cfg.getBoolean("Nick"))
      {
        ItemStack i12 = new ItemStack(Material.NAME_TAG);
        ItemMeta im12 = i12.getItemMeta();
        im12.setDisplayName("§7Autonick §aAn");
        i12.setItemMeta(im12);
        
        p.getInventory().setItem(4, i12);
      }
      else
      {
        ItemStack i12 = new ItemStack(Material.NAME_TAG);
        ItemMeta im12 = i12.getItemMeta();
        im12.setDisplayName("§7Autonick §cAus");
        i12.setItemMeta(im12);
        
        p.getInventory().setItem(4, i12);
      }
    }
    if (cfg.getString("PlayerHider").equals("alle"))
    {
      ItemStack i12 = new ItemStack(Material.INK_SACK, 1, (short)10);
      ItemMeta im12 = i12.getItemMeta();
      im12.setDisplayName("§aAlle");
      i12.setItemMeta(im12);
      
      p.getInventory().setItem(8, i12);
      
      PlayerHider_Event.Alle(p);
    }
    else if (cfg.getString("PlayerHider").equals("freunde"))
    {
      ItemStack i12 = new ItemStack(Material.INK_SACK, 1, (short)14);
      ItemMeta im12 = i12.getItemMeta();
      im12.setDisplayName("§6Freunde");
      i12.setItemMeta(im12);
      
      p.getInventory().setItem(8, i12);
      
      PlayerHider_Event.Freunde(p);
    }
    else if (cfg.getString("PlayerHider").equals("nix"))
    {
      ItemStack i12 = new ItemStack(Material.INK_SACK, 1, (short)1);
      ItemMeta im12 = i12.getItemMeta();
      im12.setDisplayName("§4Keinen");
      i12.setItemMeta(im12);
      
      p.getInventory().setItem(8, i12);
      
      PlayerHider_Event.Keine(p);
    }
    
    if(api.getKills("", p) == 0){
    	
    }
  }
}
