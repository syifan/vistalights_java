/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author yifan
 *
 */
public interface EventTriggerFactory {
	public EventTrigger produceTrigger(JsonNode json);
}
