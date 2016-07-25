package com.binaryoverload.playerpunishment.punishments;

import java.util.ArrayList;
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
	
	public void addPunishment(Player p, PunishmentBase punishment){
		if(isPunished(p)){
			List<PunishmentBase> punishments = punishedPlayers.get(p);
			
			punishments.add(punishment);
			
			punishedPlayers.put(p, punishments);
		} else {
			List<PunishmentBase> punishments = new ArrayList<PunishmentBase>();
			
			punishments.add(punishment);
			
			punishedPlayers.put(p, punishments);
		}
	}
	
	public void removePunishment(Player p, PunishmentBase punishment){
		if(isPunished(p)){
			if(punishedPlayers.get(p).contains(punishment)){
				List<PunishmentBase> punishments = punishedPlayers.get(p);
			
				punishments.remove(punishment);
				
				if(punishments.size() == 0){
					punishedPlayers.remove(p);
				} else {
					punishedPlayers.put(p, punishments);
				}
			}
		}
	}
	
	public List<PunishmentBase> getPunishments(Player p){
		if(isPunished(p)){
			return punishedPlayers.get(p);
		} else {
			return null;
		}
	}

}
