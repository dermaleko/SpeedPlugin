package de.dermaleko;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@Getter
public class SpeedCommand implements CommandExecutor {

  @Getter
  private List<Player> speed = new ArrayList<Player>();

  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

    if(!(sender instanceof Player)) {
      sender.sendMessage("§cDu musst ein Spieler sein!");
      return true;
    }
    Player player = (Player)sender;

    if(!player.hasPermission("system.speed")) {
      player.sendMessage("§cKeine Rechte!");
      return true;
    }
    if(strings.length == 0) {
      if(!speed.contains(player)) {
        speed.add(player);
        player.setWalkSpeed(1F);
        player.setFlySpeed(1F);
        player.sendMessage("§7Speed§8: §cON");
      } else {
        speed.remove(player);
        player.setWalkSpeed(0.2F);
        player.setFlySpeed(0.1F);
        player.sendMessage("§7Speed§8: §cOFF");
      }

    } else if(strings.length == 1) {
      if(!player.hasPermission("system.speed.others")) {
        player.sendMessage("§cKeine Rechte!");
        return true;
      }

      Player target = Bukkit.getPlayer(strings[0]);
      if(target == null) {
        player.sendMessage("§cDieser Spieler ist nicht online!");
        return true;
      }
      if(!speed.contains(target)) {
        speed.add(target);
        target.setWalkSpeed(1F);
        target.setFlySpeed(1F);
        target.sendMessage("§7Speed§8: §cON");
        player.sendMessage("§7Speed§8: §7(§c" + target.getName() + "§7) §cON");
      } else {
        speed.remove(target);
        target.setWalkSpeed(0.2F);
        target.setFlySpeed(0.1F);
        target.sendMessage("§7Speed§8: §cOFF");
        player.sendMessage("§7Speed§8: §7(§c" + target.getName() + "§7) §cOFF");
      }

    } else {
      if(player.hasPermission("system.speed.others")) {
        player.sendMessage("§7Benutze §c/speed §7<Player-Name>");
      } else {
        player.sendMessage("§7Benutze §c/speed");
      }
    }
    return false;
  }
}
