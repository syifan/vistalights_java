/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

import com.logistics.simulator.vehicle.task.TaskRunner;

/**
 * @author Yifan
 *
 */
public class VehicleControllerImpl implements VehicleController {

	private Vehicle vehicle;
	private TaskRunner taskRunner;
	
	/**
	 * @param taskRunner
	 */
	public VehicleControllerImpl(Vehicle vehicle, TaskRunner taskRunner) {
		super();
		this.vehicle = vehicle;
		this.taskRunner = taskRunner;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleController#tick()
	 */
	@Override
	public void tick() {
		taskRunner.run(vehicle.getSchedule());
	}

}
