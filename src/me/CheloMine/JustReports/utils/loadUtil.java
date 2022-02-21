package me.CheloMine.JustReports.utils;

import org.bukkit.Bukkit;

import me.CheloMine.JustReports.JustReports;
import me.CheloMine.JustReports.commands.CommandClose;
import me.CheloMine.JustReports.commands.CommandReport;
import me.CheloMine.JustReports.listeners.QuitListener;

public class loadUtil {

	public static void loadListeners(JustReports plugin) {
		Bukkit.getPluginManager().registerEvents(new QuitListener(plugin), plugin);
	}
	public static void loadCommands(JustReports plugin) {
		plugin.getCommand("report").setExecutor(new CommandReport(plugin));
		plugin.getCommand("close").setExecutor(new CommandClose(plugin));
	}
}
