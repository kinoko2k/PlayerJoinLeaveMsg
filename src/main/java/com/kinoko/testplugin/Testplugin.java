package com.kinoko.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testplugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Hello World!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Hello World!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "MesiOka" + ChatColor.LIGHT_PURPLE + "Server" + ChatColor.WHITE + "]" + player.getName() + ChatColor.GREEN + "がログインしました");
        } else {
            Inventory inv = player.getInventory();
            //ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
            //ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
            //player.getInventory().setItem(0,sword);
            //player.getInventory().setHelmet(helmet);
            //player.updateIntentory();
            inv.setItem(0, new ItemStack(Material.WOODEN_PICKAXE,1));
            inv.setItem(1, new ItemStack(Material.WOODEN_AXE,1));
            inv.setItem(2, new ItemStack(Material.WOODEN_SHOVEL,1));
            event.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "MesiOka" + ChatColor.LIGHT_PURPLE + "Server" + ChatColor.WHITE + "]" + player.getName() + ChatColor.YELLOW + "が初ログインしました");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "MesiOka" + ChatColor.LIGHT_PURPLE + "Server" + ChatColor.WHITE + "]" + player.getName() + ChatColor.GREEN + "がログアウトしました");
    }
}
