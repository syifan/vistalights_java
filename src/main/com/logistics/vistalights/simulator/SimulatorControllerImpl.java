/**
 * Logistics server side
 */
package com.logistics.simulator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleController;

/**
 * @author yifan
 *
 */
public class SimulatorControllerImpl implements SimulatorController {

	private Simulator simulator;
	private Set<VehicleController> vehicleControllers = 
			new HashSet<VehicleController>();

	public SimulatorControllerImpl(Simulator simulator) {
		this.simulator = simulator;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.SimulatorController#addVehicleController(com.logistics.simulator.vehicle.VehicleController)
	 */
	@Override
	public void addVehicleController(VehicleController vehicleController) {
		this.vehicleControllers.add(vehicleController);
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.SimulatorController#tick()
	 */
	@Override
	public void tick() {
		synchronized(vehicleControllers) {
			for (VehicleController vehicleController : vehicleControllers) {
				vehicleController.tick();
			}
		}
	}

}
