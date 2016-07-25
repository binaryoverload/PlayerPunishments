package com.binaryoverload.playerpunishment.punishments;

import java.util.List;

import org.bukkit.entity.Player;

import com.binaryoverload.playerpunishment.Events;

/**
 * The base class for all punishments to extend
 * 
 * @author BinaryOverload
 *
 */

public abstract class PunishmentBase {
	
	private String name;
	private String desc;
	private String message;
	private boolean eventTrigger;
	private Events event;
	private Integer interval;
	
	/**
	 * The contructor for the abstact class PunishmentBase
	 * 
	 * @param name The nice name given to the punishment
	 * @param desc The description for the punishment
	 * @param message The message sent to the punished user
	 * @param eventTrigger Whether the punishment relies on an event to work
	 * @param event If eventTrigger is true what event to execute on?
	 * @param interval If eventTrigger was false this would determine how often the punishment will be applied in ticks
		
	*/
	PunishmentBase(String name, String desc, String message, boolean eventTrigger, Events event, Integer interval){
		this.name = name;
		this.desc = desc;
		this.message = message;
		this.eventTrigger = eventTrigger;
		if(!eventTrigger){
			this.interval = interval;
		} else {
			this.event = event;
		}
	}

	public String getDesc() {
		return desc;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}

	public Integer getInterval() {
		return interval;
	}

	public boolean eventTriggered() {
		return eventTrigger;
	}

	public Events getEvent() {
		return event;
	}
	
	/**
	 * The function that will run once 
	 */
	public abstract void runOnce();

	/**
	 * The function to run when executing the punishment
	 * 
	 * @param p The online players
	 */
	public abstract void run(List<Player> p);
	

	
	
}
