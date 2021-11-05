package de.rexlNico.Lobby.Methodes;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class Var
{
  public static String pr = "§8『§3rexlManu.de§8』§8● §bPointWars§8» §r";
  public static String noperm = pr + "§7Dazu hast du keine §4Berechtigung§7.";
  public static String error = pr + "§7Bitte nutze §c/";
  public static String console = pr + "§4Das kann nur ein Spieler ausführen.";
  public static String notOnline = pr + "§cDieser Spieler befindet sich nicht auf dem Netzwerk.";
  public static File file = new File("/plugins/Lobby/config.yml");
  public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  public static File sfile = new File("/plugins/Lobby/Spawns.yml");
  public static YamlConfiguration scfg = YamlConfiguration.loadConfiguration(sfile);
}
