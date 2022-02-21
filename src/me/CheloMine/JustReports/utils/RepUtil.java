package me.CheloMine.JustReports.utils;

import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import me.CheloMine.JustReports.JustReports;

public class RepUtil {
	
	private JustReports plugin;
	public RepUtil(JustReports plugin) {
		this.plugin = plugin;
	}
	
	public void set(String path, Object value) {
		YamlConfiguration repConfig = YamlConfiguration.loadConfiguration(plugin.repFile);
		repConfig.set(path, value);
		try {
			repConfig.save(plugin.repFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getInt(String path) {
		YamlConfiguration repConfig = YamlConfiguration.loadConfiguration(plugin.repFile);
		return repConfig.getInt(path);
	}
	public String getString(String path) {
		YamlConfiguration repConfig = YamlConfiguration.loadConfiguration(plugin.repFile);
		return repConfig.getString(path);
	}
	public long getLong(String path) {
		YamlConfiguration repConfig = YamlConfiguration.loadConfiguration(plugin.repFile);
		return repConfig.getLong(path);
	}

}
