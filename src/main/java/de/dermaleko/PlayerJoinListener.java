package de.dermaleko;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    if(Speed.getInstance().getSpeedCommand().getSpeed().contains(event.getPlayer())) { Speed.getInstance().getSpeedCommand().getSpeed().remove(event.getPlayer()); }
    event.getPlayer().setWalkSpeed(0.2F);
    event.getPlayer().setFlySpeed(0.1F);

  }

}
