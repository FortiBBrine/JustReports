package me.CheloMine.JustReports.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.CheloMine.JustReports.JustReports;

public class CommandReports implements CommandExecutor {

	private JustReports plugin;
	public CommandReports(JustReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
}
