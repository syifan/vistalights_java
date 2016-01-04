/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

/**
 * @author Yifan
 *
 */
public interface VehicleRemover {
	/**
	 * Remove the vehicle from both the viewport and the simulator
	 * @param vehicle
	 */
	public void removeVehicle(Vehicle vehicle);
}
