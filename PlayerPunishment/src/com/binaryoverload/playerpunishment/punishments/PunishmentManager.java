package com.binaryoverload.playerpunishment.punishments;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

public class PunishmentManager {
	
	private PunishmentManager instance = new PunishmentManager();
	
	private PunishmentManager() {}
	
	public PunishmentManager getInstance() {
		return instance;
	}
	
	HashMap<Player, List<PunishmentBase>> punishedPlayers = new HashMap<Player, List<PunishmentBase>>();
	
	public boolean isPunished(Player p){
		if(punishedPlayers.containsKey(p) && punishedPlayers.get(p) != null){
			return true;
		} else if(punishedPlayers.get(p) == null){
			punishedPlayers.remove(p);
			return false;
		} else {
			return false;
		}
	}

}
