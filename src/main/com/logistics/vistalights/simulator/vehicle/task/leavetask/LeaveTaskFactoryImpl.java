/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.leavetask;

import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleRemover;

/**
 * @author Yifan
 *
 */
public class LeaveTaskFactoryImpl implements LeaveTaskFactory {
	private VehicleRemover vehicleRemover;

	/**
	 * @param vehicleRemover
	 */
	public LeaveTaskFactoryImpl(VehicleRemover vehicleRemover) {
		super();
		this.vehicleRemover = vehicleRemover;
	}

	public LeaveTask produceLeaveTask(LocalDateTime time, Vehicle vehicle) {
		LeaveTask leaveTask = new LeaveTask(time);
		LeaveTaskReserver reserver = new LeaveTaskReserver(leaveTask);
		leaveTask.setTaskReserver(reserver);
		LeaveTaskExecutor executor = new LeaveTaskExecutor(vehicle, 
				vehicleRemover);
		leaveTask.setTaskExecutor(executor);
		return leaveTask;
	}
}
