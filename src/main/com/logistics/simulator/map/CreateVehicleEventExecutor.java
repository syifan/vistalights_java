/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Yifan
 *
 */
public class CreateVehicleEventExecutor implements EventExecutor {
	
	private CreateVehicleMapEvent event;
	private VehicleCreator vehicleCreator;
	

	/**
	 * @param event
	 * @param vehicleCreator
	 */
	public CreateVehicleEventExecutor(CreateVehicleMapEvent event,
			VehicleCreator vehicleCreator) {
		super();
		this.event = event;
		this.vehicleCreator = vehicleCreator;
	}


	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.EventExecutor#execute()
	 */
	@Override
	public void execute() {
		JsonNode vehicleInformation = event.getVehicleInformation();
		vehicleCreator.createVehicle(vehicleInformation);
	}

}
