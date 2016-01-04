/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author yifan
 *
 */
public interface MapEventFactory {
	public MapEvent produceMapEvent(JsonNode mapEvent);
}
