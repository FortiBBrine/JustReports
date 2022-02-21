package me.CheloMine.JustReports.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import me.CheloMine.JustReports.JustReports;

@SuppressWarnings("unused")
public class CommandClose implements CommandExecutor {
	
	private JustReports plugin;
	public CommandClose(JustReports plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(plugin.messageUtil.get("console.NotPlayer").replace("&", "§"));
			return true;
		}
		Player p = (Player) sender;
		
		if (plugin.reporting.containsKey(p)) {
			
			return true;
		}
		
		if (!plugin.reports.containsKey(p)) {
			p.sendMessage(plugin.messageUtil.get("player.noReports").replace("&", "§"));
			return true;
		}
		
		plugin.reports.remove(p);
		p.sendMessage(plugin.messageUtil.get("player.closeReport").replace("&", "§"));
		
		Permission perm = plugin.getDescription().getPermissions().get(1);
		
		String message = plugin.messageUtil.get("admin.closeReport");
		message = message.replace("%player", p.getName());
		message = message.replace("&", "§");
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.hasPermission(perm)) continue;
		
			player.sendMessage(message);
		}
		
		return true;
	}
}
