/**
 * Logistics server side
 */
package com.logistics.simulator;

import com.logistics.simulator.vehicle.Vehicle;


/**
 * @author Yifan
 *
 */
public interface AddVehicleSubscriber {
	public void addVehicleNotify(Vehicle vehicle);
}
