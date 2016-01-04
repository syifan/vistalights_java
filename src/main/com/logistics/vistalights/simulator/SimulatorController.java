/**
 * Logistics server side
 */
package com.logistics.simulator;

import com.logistics.simulator.vehicle.VehicleController;

/**
 * @author yifan
 *
 */
public interface SimulatorController {
	
	public void tick();
	public void addVehicleController(VehicleController vehicleController);
	
}
