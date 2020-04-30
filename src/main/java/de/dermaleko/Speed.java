package de.dermaleko;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
@Getter
public class Speed extends JavaPlugin {

  @Getter
  public static Speed instance;
  private SpeedCommand speedCommand;

  @Override
  public void onEnable() {
    instance = this;
    this.speedCommand = new SpeedCommand();
    Bukkit.getPluginCommand("speed").setExecutor(new SpeedCommand());
    Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
  }
}
