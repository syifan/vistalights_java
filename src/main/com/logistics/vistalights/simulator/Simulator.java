/**
 * Logistics server side
 */
package com.logistics.simulator;

import java.util.Map;

import com.logistics.simulator.vehicle.Vehicle;

/**
 * @author yifan
 *
 */
public interface Simulator {
	public void addVehicle(Vehicle vehicle);
	public Map<Integer, Vehicle> getVehicles();
	/**
	 * @param vehicleProducer
	 */
	public void addAddVehicleSubscriber(AddVehicleSubscriber vehicleProducer);
}
