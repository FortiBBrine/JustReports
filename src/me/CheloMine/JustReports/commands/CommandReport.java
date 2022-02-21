package me.CheloMine.JustReports.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import me.CheloMine.JustReports.JustReports;

public class CommandReport implements CommandExecutor {

	private JustReports plugin;
	public CommandReport(JustReports plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(plugin.messageUtil.get("console.NotPlayer").replace("&", "§"));
			return true;
		}
		Player p = (Player) sender;

		if (args.length < 1) {
			for (String message : plugin.messageUtil.getList("player.usage")) {
				message = message.replace("&", "§");
				p.sendMessage(message);
			}
			return true;
		}
		
		if (plugin.reports.containsKey(p)) {
			p.sendMessage(plugin.messageUtil.get("player.alreadyExists").replace("&", "§"));
			return true;
		}

		String report = "";
		for (String i : args) {
			report += i+" ";
		}
		report = report.trim();
		
		plugin.reports.put(p, report);
		p.sendMessage(plugin.messageUtil.get("player.sendReport").replace("&", "§"));
		
		String message = plugin.messageUtil.get("admin.sendReport");
		message = message.replace("%player", p.getName());
		message = message.replace("%report", report);
		message = message.replace("&", "§");
		
		Permission perm = plugin.getDescription().getPermissions().get(1);
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.hasPermission(perm)) continue;
		
			player.sendMessage(message);
		}
		return true;
	}
	
}
