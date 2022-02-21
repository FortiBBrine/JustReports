package me.CheloMine.JustReports.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;

import me.CheloMine.JustReports.JustReports;

public class QuitListener implements Listener {
	
	private JustReports plugin;
	public QuitListener(JustReports plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (plugin.reports.containsKey(p)) {
			plugin.reports.remove(p);
			
			Permission perm = plugin.getDescription().getPermissions().get(1);
			
			String message = plugin.messageUtil.get("admin.playerLeave");
			message = message.replace("%player", p.getName());
			message = message.replace("&", "§");
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (!player.hasPermission(perm)) continue;
			
				player.sendMessage(message);
			}
		}
	}
}
