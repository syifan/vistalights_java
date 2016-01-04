/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author yifan
 *
 */
public class MapEventFactoryImpl implements MapEventFactory {
	
	private EventTriggerFactory eventTriggerFactory;
	private VehicleCreator vehicleCreator;

	/**
	 * @param eventTriggerFactory
	 */
	public MapEventFactoryImpl(EventTriggerFactory eventTriggerFactory,
			VehicleCreator vehicleCreator) {
		super();
		this.eventTriggerFactory = eventTriggerFactory;
		this.vehicleCreator = vehicleCreator;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEventFactory#produceMapEvent(com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public MapEvent produceMapEvent(JsonNode mapEvent) {
		// Check if type is defined
		if (mapEvent.get("type") == null) {
			try {
				throw new Exception("Type is not defined in map event.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Produce map event according to different type
		switch(mapEvent.get("type").asText()) {
		case "create vehicle":
			return produceCreateVehicleEvent(mapEvent);
		default:
			try {
				throw new Exception("Unknown map event type: " + 
						mapEvent.get("type").asText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * @return
	 */
	protected MapEvent produceCreateVehicleEvent(JsonNode json) {
		CreateVehicleMapEvent event = new CreateVehicleMapEvent();
		EventTrigger trigger = eventTriggerFactory.produceTrigger(
				json.get("trigger"));
		event.setTrigger(trigger);
		event.setVehicleInformation(json.get("vehicle"));
		
		CreateVehicleEventExecutor executor = new CreateVehicleEventExecutor(
				event, vehicleCreator);
		event.setEventExecutor(executor);
		
		return event;
	}

}
