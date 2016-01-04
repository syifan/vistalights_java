/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.task.TaskRunnerImpl;

/**
 * @author Yifan
 *
 */
public class VehicleImplFactory implements VehicleFactory {

	Scheduler scheduler;
	
	/**
	 * @param scheduler
	 */
	public VehicleImplFactory(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleFactory#produceVehicle()
	 */
	@Override
	public Vehicle produceVehicle(int id) {
		VehicleImpl vehicle = new VehicleImpl(id);
		vehicle.setTaskRunner(new TaskRunnerImpl(scheduler));
		return vehicle;
	}

}
