/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.util.Iterator;
import java.util.Set;


/**
 * @author Yifan
 *
 */
public class MapEventRunnerImpl implements MapEventRunner {
	
	protected Map map;

	/**
	 * @param map
	 */
	public MapEventRunnerImpl(Map map) {
		super();
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEventRunner#tick()
	 */
	@Override
	public void tick() {
		Set<MapEvent> events = map.getMapEvents();
		Iterator<MapEvent> it = events.iterator();
		while(it.hasNext()) {
			MapEvent event = it.next();
			EventTrigger eventTrigger = event.getEventTrigger();
			if (eventTrigger.doTrigger()) {
				EventExecutor eventExecutor = event.getEventExecutor();
				eventExecutor.execute();
			}
			if (eventTrigger.isInvalid()) {
				it.remove();
			}
		}
	}

}
