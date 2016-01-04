/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Yifan
 *
 */
public interface MapEventLoader {
	public void loadMapEvents(JsonNode json);
}
