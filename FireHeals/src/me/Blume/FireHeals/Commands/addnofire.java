package me.Blume.FireHeals.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Blume.FireHeals.Main;


public class addnofire implements CommandExecutor{

	private Main plugin;
	public addnofire(Main plugin) {
		this.plugin=plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length==0) {
				if(label.equals("addnofire")) {
					if(!plugin.getnofire().contains(player.getUniqueId())) {
						player.sendMessage("No Fire added");
						plugin.addnofire(player);
					}
				}
			}
		}


		return false;
	}
}
