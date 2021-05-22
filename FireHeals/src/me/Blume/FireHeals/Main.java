package me.Blume.FireHeals;

import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.Blume.FireHeals.Listeners.nofirevent;



public class Main extends JavaPlugin{
	public ArrayList<UUID> nofire = new ArrayList<UUID>();
	@Override
	public void onEnable() {
		getCommand("addnofire").setExecutor(new me.Blume.FireHeals.Commands.addnofire(this));
		getCommand("removenofire").setExecutor(new me.Blume.FireHeals.Commands.removenofire(this));
		getServer().getPluginManager().registerEvents(new nofirevent(this), this);
	}
	@Override
	public void onDisable() {
		
	}
	public ArrayList<UUID> getnofire(){
		return nofire;
	}
	public void addnofire(Player player) {
		nofire.add(player.getUniqueId());
	}
	public void removenofire(Player player) {
		nofire.remove(player.getUniqueId());
	}
}
