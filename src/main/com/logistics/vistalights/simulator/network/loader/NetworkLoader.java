/**
 * Logistics server side
 */
package com.logistics.simulator.network.loader;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A NetworkLoader loads the network from a JSON object
 * @author yifan
 *
 */
public interface NetworkLoader {
	public void loadNetwork(JsonNode jsonFile);
}
