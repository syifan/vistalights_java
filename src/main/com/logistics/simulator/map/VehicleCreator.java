/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Yifan
 *
 */
public interface VehicleCreator {
	public void createVehicle(JsonNode json);
}
