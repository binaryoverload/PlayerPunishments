package com.binaryoverload.playerpunishment.punishments;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BrokenLegs extends PunishmentBase{

	BrokenLegs() {
		super("Broken Legs", "Breaks the players legs making them unable to jump!", "Your legs have been broken!", false, null, 20);
	}
	
	// TODO Convert function with a PunishmentManager

	public void run(Player p) {
		
		PotionEffect potionEffect = new PotionEffect(PotionEffectType.JUMP, this.getInterval() + 1, 128);
		p.addPotionEffect(potionEffect);
		
		potionEffect = new PotionEffect(PotionEffectType.SLOW, this.getInterval() + 1, 2);
		p.addPotionEffect(potionEffect);
		
		CommandSender cs = Bukkit.getConsoleSender();
        Bukkit.getServer().dispatchCommand(cs, "execute " + p.getName() + " ~ ~ ~ particle reddust ~ ~ ~ ~ ~0.1 ~ 0");
	}

	public void runOnce() {}

	@Override
	public void run(List<Player> p) {
		
	}

}
