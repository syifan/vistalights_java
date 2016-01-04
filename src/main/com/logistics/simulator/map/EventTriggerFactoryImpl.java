/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.logistics.simulator.scheduler.Scheduler;

/**
 * @author yifan
 *
 */
public class EventTriggerFactoryImpl implements EventTriggerFactory {

	private Scheduler scheduler;
	
	/**
	 * @param scheduler
	 */
	public EventTriggerFactoryImpl(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.EventTriggerFactory#produceTrigger(com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public EventTrigger produceTrigger(JsonNode json) {
		switch(json.get("type").asText()) {
		case "at time":
			DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss");
			LocalDateTime time = LocalDateTime.parse(json.get("time").asText(),
					formatter);
			AtTimeEventTrigger trigger =  new AtTimeEventTrigger(scheduler);
			trigger.setTime(time);
			return trigger;
		default:
			try {
				throw new Exception("Unsupported map event trigger type: " + 
						json.get("type").asText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
