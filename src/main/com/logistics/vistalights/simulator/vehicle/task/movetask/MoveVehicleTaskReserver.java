/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import java.time.LocalDateTime;

import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.vehicle.task.TaskReserver;

/**
 * @author Yifan
 *
 */
public class MoveVehicleTaskReserver implements TaskReserver {
	protected MoveVehicleTask task;
	protected RoadConnection connection;

	/**
	 * @param task
	 * @param connection
	 */
	public MoveVehicleTaskReserver(MoveVehicleTask task,
			RoadConnection connection) {
		super();
		this.task = task;
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#hasConflict()
	 */
	@Override
	public boolean hasConflict() {
		if(connection == null) return false;
		return connection.isTimeSlotAvailable(
				task.getStartTime(), task.getEndTime());
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#nextNoConflictTime()
	 */
	@Override
	public LocalDateTime nextNoConflictTime() {
		if (connection == null) return task.getStartTime();
		return connection.nextAvailableTime(
				task.getStartTime(), task.getEndTime());
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#makeReservation()
	 */
	@Override
	public void makeReservation() {
		if (connection != null) {
			connection.reserve(task.getStartTime(), 
					task.getEndTime().plusMinutes(120));
		}
	}

}
