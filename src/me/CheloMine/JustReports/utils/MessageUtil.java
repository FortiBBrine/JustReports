package me.CheloMine.JustReports.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import me.CheloMine.JustReports.JustReports;

@SuppressWarnings("unused")
public class MessageUtil {
	
	private JustReports plugin;
	private YamlConfiguration messageConfig;
	public MessageUtil(JustReports plugin) {
		this.plugin = plugin;
		messageConfig = YamlConfiguration.loadConfiguration(plugin.messageFile);
	}
	
	public String get(String path) {
		return messageConfig.getString(path, "");
	}
	
	public List<String> getList(String path) {
		return messageConfig.getStringList(path);
	}
}
