/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Yifan
 *
 */
public class MapEventLoaderImpl implements MapEventLoader {
	
	protected Map map;
	protected MapEventFactory mapEventFactory;

	/**
	 * @param map
	 * @param mapEventFactory
	 */
	public MapEventLoaderImpl(Map map, MapEventFactory mapEventFactory) {
		super();
		this.map = map;
		this.mapEventFactory = mapEventFactory;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEventLoader#loadMapEvents(com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public void loadMapEvents(JsonNode json) {
		for (JsonNode event : json) {
			MapEvent mapEvent = mapEventFactory.produceMapEvent(event);
			map.addMapEvent(mapEvent);
		}

	}

}
