/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.unloadingtask;

import java.time.LocalDateTime;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.task.TaskReserver;

/**
 * @author Yifan
 *
 */
public class UnloadingTaskReserver implements TaskReserver {
	
	private Node node;
	private UnloadingTask task;

	/**
	 * @param node
	 * @param task
	 */
	public UnloadingTaskReserver(Node node, UnloadingTask task) {
		super();
		this.node = node;
		this.task = task;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#hasConflict()
	 */
	@Override
	public boolean hasConflict() {
		return node.isTimeSlotAvailable(task.getStartTime(), task.getEndTime());
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#nextNoConflictTime()
	 */
	@Override
	public LocalDateTime nextNoConflictTime() {
		return node.nextAvailableTime(task.getStartTime(), task.getEndTime());
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskReserver#makeReservation()
	 */
	@Override
	public void makeReservation() {
		node.reserve(task.getStartTime(), task.getEndTime());
	}

}
