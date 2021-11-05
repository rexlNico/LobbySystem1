package de.rexlNico.Lobby.Commands;

import de.rexlNico.Lobby.Methodes.Factory;
import de.rexlNico.Lobby.Methodes.Var;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeleporterSpawns
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (p.hasPermission("lobby.setmody"))
      {
        if (args.length == 1)
        {
          if (args[0].equalsIgnoreCase("poinwars")) {
            setModus(p, "PoinWars");
          } else if (args[0].equalsIgnoreCase("spawn")) {
            setModus(p, "Spawn");
          } else if (args[0].equalsIgnoreCase("rexlunity")) {
            setModus(p, "rexlUnity");
          }
        }
        else {
          p.sendMessage(Var.error + "setmody <PoinWars/Spawn/rexlUnity/.../.../.../.../.../...>");
        }
      }
      else {
        p.sendMessage(Var.noperm);
      }
    }
    else
    {
      sender.sendMessage(Var.console);
    }
    return false;
  }
  
  public static void setModus(Player p, String Modus)
  {
    Factory.createConfigLocation(p.getLocation(), "mody." + Modus, Var.sfile, Var.scfg);
    p.sendMessage(Var.pr + "§7Du hast den Modus §a" + Modus + " �7gesetzt.");
  }
  
  public static void tpToModus(Player p, String Modus)
  {
    p.teleport(Factory.getConfigLocation("mody." + Modus, Var.scfg));
  }
}
