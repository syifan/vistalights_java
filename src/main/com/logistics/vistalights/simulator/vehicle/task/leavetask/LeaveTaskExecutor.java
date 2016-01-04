/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.leavetask;

import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleRemover;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class LeaveTaskExecutor implements VehicleTaskExecutor {
	
	protected Vehicle vehicle;
	protected VehicleRemover vehicleRemover;

	/**
	 * @param vehicle
	 * @param vehicleRemover
	 */
	public LeaveTaskExecutor(Vehicle vehicle, VehicleRemover vehicleRemover) {
		super();
		this.vehicle = vehicle;
		this.vehicleRemover = vehicleRemover;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#initialize()
	 */
	@Override
	public void initialize() {
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#isInitiated()
	 */
	@Override
	public boolean isInitiated() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#execute()
	 */
	@Override
	public void execute() {
		vehicleRemover.removeVehicle(vehicle);
	}

}
