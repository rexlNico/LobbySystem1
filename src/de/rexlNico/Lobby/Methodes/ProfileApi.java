package de.rexlNico.Lobby.Methodes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ProfileApi {

	
	
	public static int getKills(String Modus, Player p){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
	      int k = cfg.getInt("Stats."+Modus+".kills");
	      
		return k;
	}
	public static int getTode(String Modus, Player p){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      int d = cfg.getInt("Stats."+Modus+".Tode");
		return d;
	}
	public static double getKD(String Modus, Player p){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      double kd = cfg.getInt("Stats."+Modus+".Kills")/cfg.getInt("Stats."+Modus+".Tode");
		return kd;
	}
	public static int getPlayedGames(String Modus, Player p){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      int pg = cfg.getInt("Stats."+Modus+".PlayedGames");
		return pg;
	}
	public static int getGewonnen(String Modus, Player p){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      int wi = cfg.getInt("Stats."+Modus+".Winns");
		return wi;
	}
	
	public static void setKills(String Modus, Player p,int i){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      cfg.set("Stats."+Modus+".Kills", i);
	      try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setTode(String Modus, Player p,int i){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      cfg.set("Stats."+Modus+".Tode", i);
	      try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setPlayedGames(String Modus, Player p,int i){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      cfg.set("Stats."+Modus+".PlayedGames", i);
	      try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setGewonnen(String Modus, Player p,int i){
	      File file = new File("plugins/Lobby/players/" + p.getUniqueId().toString() + ".yml");
	      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	      cfg.set("Stats."+Modus+".Winns", i);
	      try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
