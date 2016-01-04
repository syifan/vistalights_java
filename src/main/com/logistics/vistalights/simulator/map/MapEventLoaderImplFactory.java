/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.logistics.simulator.scheduler.Scheduler;

/**
 * @author Yifan
 *
 */
public class MapEventLoaderImplFactory implements MapEventLoaderFactory {

	private Map map;
	private Scheduler scheduler;
	private VehicleCreator vehicleCreator;

	/**
	 * @param map
	 * @param scheduler
	 * @param vehicleCreator
	 */
	public MapEventLoaderImplFactory(Map map, Scheduler scheduler,
			VehicleCreator vehicleCreator) {
		super();
		this.map = map;
		this.scheduler = scheduler;
		this.vehicleCreator = vehicleCreator;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEventLoaderFactory#produceMapEventLoader()
	 */
	@Override
	public MapEventLoader produceMapEventLoader() {
		EventTriggerFactory eventTriggerFactory = 
				new EventTriggerFactoryImpl(scheduler);
		MapEventFactory mapEventFactory = 
				new MapEventFactoryImpl(eventTriggerFactory, vehicleCreator);
		MapEventLoaderImpl mapEventLoader = new MapEventLoaderImpl(map, 
				mapEventFactory);
		return mapEventLoader;
	}


}
