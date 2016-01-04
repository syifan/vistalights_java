/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;


/**
 * @author Yifan
 *
 */
public class MoveVehicleTaskExecutor implements VehicleTaskExecutor {
	// Dependencies
	protected Vehicle vehicle;
	protected Pilot pilot;
	protected MoveVehicleTask task;
	
	// Member fields
	protected boolean initialized;
	protected boolean finished;
	protected double timeInSecondLeft;
	
	public MoveVehicleTaskExecutor(MoveVehicleTask task,
			Vehicle vehicle, Pilot pilot) {
		this.task = task;
		this.vehicle = vehicle;
		this.pilot = pilot;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#execute()
	 */
	@Override
	public void execute() {
//		pilot.setDestination(task.getDestination().getPosition(), 
//				task.getEndTime());
		pilot.moveVehicle();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#start()
	 */
	@Override
	public void initialize() {
		pilot.setDestination(task.getDestination().getPosition(), 
				task.getEndTime());
		initialized = true;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#isInitiated()
	 */
	@Override
	public boolean isInitiated() {
		return initialized;
	}

}
