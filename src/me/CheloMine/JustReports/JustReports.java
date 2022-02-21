package me.CheloMine.JustReports;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.CheloMine.JustReports.utils.MessageUtil;
import me.CheloMine.JustReports.utils.RepUtil;
import me.CheloMine.JustReports.utils.loadUtil;

public class JustReports extends JavaPlugin {

	public File repFile = new File(getDataFolder()+File.separator+"rep.yml");
	public File messageFile = new File(getDataFolder()+File.separator+"message.yml");
	
	public RepUtil repUtil;
	public MessageUtil messageUtil;
	
	public Map<Player, String> reports = new HashMap<Player, String>();
	public Map<Player, Player> reporting = new HashMap<Player, Player>();
	
	@Override
	public void onEnable() {
		File config = new File(getDataFolder()+File.separator+"config.yml");
		if (!config.exists()) {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		if (!repFile.exists()) this.saveResource("rep.yml", false);
		if (!messageFile.exists()) this.saveResource("message.yml", false);
		
		repUtil = new RepUtil(this);
		messageUtil = new MessageUtil(this);
		
		loadUtil.loadCommands(this);
		loadUtil.loadListeners(this);
	}
}
