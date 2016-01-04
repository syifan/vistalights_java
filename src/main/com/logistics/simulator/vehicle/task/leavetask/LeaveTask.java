/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.leavetask;

import java.time.Duration;
import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class LeaveTask implements VehicleTask {
	
	protected LocalDateTime time;
	protected LeaveTaskReserver reserver;
	protected LeaveTaskExecutor executor;

	/**
	 * @param time
	 */
	public LeaveTask(LocalDateTime time) {
		super();
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getStartTime()
	 */
	@Override
	public LocalDateTime getStartTime() {
		return time;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getEndTime()
	 */
	@Override
	public LocalDateTime getEndTime() {
		return time;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#postpone(java.time.Duration)
	 */
	@Override
	public void postpone(Duration amount) {
		time = time.plus(amount);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskExecutor()
	 */
	@Override
	public VehicleTaskExecutor getTaskExecutor() {
		return executor;
	}
	
	public void setTaskExecutor(LeaveTaskExecutor executor) {
		this.executor = executor;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskReserver()
	 */
	@Override
	public TaskReserver getTaskReserver() {
		return reserver;
	}
	
	public void setTaskReserver(LeaveTaskReserver reserver) {
		this.reserver = reserver;
	}

}
