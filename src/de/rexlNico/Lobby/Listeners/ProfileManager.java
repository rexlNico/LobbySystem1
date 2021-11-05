package de.rexlNico.Lobby.Listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.rexlNico.Lobby.Methodes.ProfileApi;

public class ProfileManager implements Listener{

	private ArrayList<String> lore1 = new ArrayList<>();
	private ArrayList<String> lore2 = new ArrayList<>();
	private ArrayList<String> lore3 = new ArrayList<>();
	private ArrayList<String> lore4 = new ArrayList<>();
	private ArrayList<String> lore5 = new ArrayList<>();
	private ArrayList<String> lore6 = new ArrayList<>();
	private ArrayList<String> lore7 = new ArrayList<>();
	private ProfileApi api = new ProfileApi();
	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void on(PlayerInteractEvent e){
	Player p = e.getPlayer();	
    if (((e.getAction().equals(Action.LEFT_CLICK_AIR)) || 
    	      (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || 
    	      (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) || 
    	      (e.getAction().equals(Action.RIGHT_CLICK_AIR))) && 
    	      (p.getItemInHand().getType().equals(Material.SKULL_ITEM))){
    		//Stats PoinWars
    	String m = "PoinWars";
    	Inventory inv = Bukkit.createInventory(null, 6*9,"§dProfil");
    	lore1.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore1.add("§bKills§7: §4"+api.getKills(m, p));
    	lore1.add("§bTode§7: §4"+api.getTode(m, p));
    	lore1.add("§5KD§7: §4"+api.getKD(m, p));
    	lore1.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "§5§lPoinWars", 27+5, lore1);
    	//Stats ...
    	m = "nix";
    	lore2.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore2.add("§bKills§7: §4"+api.getKills(m, p));
    	lore2.add("§bTode§7: §4"+api.getTode(m, p));
    	lore2.add("§5KD§7: §4"+api.getKD(m, p));
    	lore2.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 3*9+3, lore2);
    	//Stats ...
    	m = "nix";
    	lore3.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore3.add("§bKills§7: §4"+api.getKills(m, p));
    	lore3.add("§bTode§7: §4"+api.getTode(m, p));
    	lore3.add("§5KD§7: §4"+api.getKD(m, p));
    	lore3.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 3*9+7, lore3);
    	//Stats ...
    	m = "nix";
    	lore4.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore4.add("§bKills§7: §4"+api.getKills(m, p));
    	lore4.add("§bTode§7: §4"+api.getTode(m, p));
    	lore4.add("§5KD§7: §4"+api.getKD(m, p));
    	lore4.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 4*9+2, lore4);
    	//Stats ...
    	m = "nix";
    	lore5.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore5.add("§bKills§7: §4"+api.getKills(m, p));
    	lore5.add("§bTode§7: §4"+api.getTode(m, p));
    	lore5.add("§5KD§7: §4"+api.getKD(m, p));
    	lore5.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 4*9+4, lore5);
    	//Stats ...
    	m = "nix";
    	lore6.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore6.add("§bKills§7: §4"+api.getKills(m, p));
    	lore6.add("§bTode§7: §4"+api.getTode(m, p));
    	lore6.add("§5KD§7: §4"+api.getKD(m, p));
    	lore6.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 4*9+6, lore6);
    	//Stats ...
    	m = "nix";
    	lore7.add("§bGespielte Spiele§7: §4"+api.getPlayedGames(m, p));
    	lore7.add("§bKills§7: §4"+api.getKills(m, p));
    	lore7.add("§bTode§7: §4"+api.getTode(m, p));
    	lore7.add("§5KD§7: §4"+api.getKD(m, p));
    	lore7.add("§bGewonnene Spiele§7: §4"+api.getGewonnen(m, p));
    	setItem(inv, Material.GOLD_NUGGET, "...", 4*9+8, lore7);
    	//Freunde
        ItemStack i3 = new ItemStack(Material.SKULL_ITEM,1,(short)3);
        ItemMeta im3 = i3.getItemMeta();
        im3.setDisplayName("§bFreunde");
        i3.setItemMeta(im3);
        SkullMeta sm = (SkullMeta) i3.getItemMeta();
        sm.setOwner(p.getName());
        i3.setItemMeta(sm);
        inv.setItem(9+4, i3);
        
        p.openInventory(inv);
    	}
	}
	
	  private void setItem(Inventory inv, Material item, String name, int Slotvon1, ArrayList<String> list)
	  {
	    ItemStack i12 = new ItemStack(item);
	    ItemMeta im12 = i12.getItemMeta();
	    im12.setDisplayName(name);
	    im12.setLore(list);
	    i12.setItemMeta(im12);
	    
	    inv.setItem(Slotvon1 - 1, i12);
	  }
	
}
