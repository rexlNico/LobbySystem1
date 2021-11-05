package de.rexlNico.Lobby.Main;

import de.rexlNico.Lobby.Commands.SetTeleporterSpawns;
import de.rexlNico.Lobby.Listeners.JoinEvent;
import de.rexlNico.Lobby.Listeners.LobbyWechsler;
import de.rexlNico.Lobby.Listeners.Nick;
import de.rexlNico.Lobby.Listeners.PlayerHider_Event;
import de.rexlNico.Lobby.Listeners.ProfileManager;
import de.rexlNico.Lobby.Listeners.Teleporter;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public static Main plugin;
  PluginManager pm = Bukkit.getPluginManager();
  
  public void onEnable()
  {
    plugin = this;
    registered();
    
    Bukkit.getConsoleSender().sendMessage("########################");
    Bukkit.getConsoleSender().sendMessage("§4Lobby §8wurde §aGeladen");
    Bukkit.getConsoleSender().sendMessage("########################");
  }
  
  public void registered()
  {
	  
	  this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	  
    pm.registerEvents(new PlayerHider_Event(), this);
    pm.registerEvents(new LobbyWechsler(), this);
    pm.registerEvents(new JoinEvent(), this);
    pm.registerEvents(new Nick(), this);
    pm.registerEvents(new Teleporter(), this);
    pm.registerEvents(new ProfileManager(), this);
    
    getCommand("setmody").setExecutor(new SetTeleporterSpawns());
  }
  
  public static Main getPlugin()
  {
    return plugin;
  }
}
