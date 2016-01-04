/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.leavetask;

import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.task.TaskReserver;

/**
 * @author Yifan
 *
 */
public class LeaveTaskReserver implements TaskReserver {
	
	protected LeaveTask task;

	/**
	 * @param task
	 */
	public LeaveTaskReserver(LeaveTask task) {
		super();
		this.task = task;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#hasConflict()
	 */
	@Override
	public boolean hasConflict() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#nextNoConflictTime()
	 */
	@Override
	public LocalDateTime nextNoConflictTime() {
		return task.getStartTime();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#makeReservation()
	 */
	@Override
	public void makeReservation() {
		// Do nothing.
	}

}
