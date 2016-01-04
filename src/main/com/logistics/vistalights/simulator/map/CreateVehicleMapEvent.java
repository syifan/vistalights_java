/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author yifan
 *
 */
public class CreateVehicleMapEvent implements MapEvent {
	protected EventTrigger trigger;
	protected EventExecutor executor;
	protected JsonNode vehicleInformation;

	/**
	 * @return the vehicleInformation
	 */
	public JsonNode getVehicleInformation() {
		return vehicleInformation;
	}

	/**
	 * @param vehicleInformation the vehicleInformation to set
	 */
	public void setVehicleInformation(JsonNode vehicleInformation) {
		this.vehicleInformation = vehicleInformation;
	}

	/**
	 * @param executor the executor to set
	 */
	public void setEventExecutor(EventExecutor executor) {
		this.executor = executor;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEvent#getEventExecutor()
	 */
	@Override
	public EventExecutor getEventExecutor() {
		return executor;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.MapEvent#getEventTrigger()
	 */
	@Override
	public EventTrigger getEventTrigger() {
		return trigger;
	}


	/**
	 * @param trigger
	 */
	public void setTrigger(EventTrigger trigger) {
		this.trigger = trigger;
	}

}
