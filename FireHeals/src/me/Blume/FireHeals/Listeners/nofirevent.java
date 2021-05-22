package me.Blume.FireHeals.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.Blume.FireHeals.Main;


public class nofirevent implements Listener{
	private Main plugin;
	public nofirevent(Main plugin) {
		this.plugin=plugin;
	}
	double health,fhealth;
	@EventHandler
	public void fallno(EntityDamageEvent event) {
		if(event.getCause()==DamageCause.LAVA||event.getCause()==DamageCause.FIRE
			|| event.getCause()==DamageCause.FIRE_TICK) {
			if(event.getEntity() instanceof Player) {
				Player player =  (Player) event.getEntity();

				if(plugin.getnofire().contains(player.getUniqueId())) {
					health = event.getDamage();
					fhealth = player.getHealth();
					if(fhealth+health<20) {
						player.setHealth(fhealth+health);
					}
					else if(fhealth+health>=20) {
						player.setHealth(20);
					}
					event.setCancelled(true);
				}
			}
		}
		else return;
	}
}
