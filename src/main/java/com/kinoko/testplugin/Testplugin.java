package com.kinoko.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testplugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Hello World!");

    }

    @Override
    public void onDisable() {
        getLogger().info("Hello World!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            event.setJoinMessage(player.getName() + ChatColor.GREEN + "がログインしました");
        } else {
            event.setJoinMessage(player.getName() + ChatColor.YELLOW + "が初ログインしました");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(player.getName() + ChatColor.GREEN + "がログアウトしました");
    }
}
