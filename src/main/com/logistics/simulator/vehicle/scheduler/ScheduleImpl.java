/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.logistics.simulator.vehicle.task.VehicleTask;

/**
 * @author Yifan
 *
 */
public class ScheduleImpl implements Schedule {
	
	protected List<VehicleTask> tasks = new ArrayList<VehicleTask>();

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Schedule#getTasks()
	 */
	@Override
	public List<VehicleTask> getTasks() {
		return tasks;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Schedule#addTask(com.logistics.simulator.vehicle.VehicleTask)
	 */
	@Override
	public void addTask(VehicleTask task) {
		tasks.add(task);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Schedule#getETA()
	 */
	@Override
	public LocalDateTime getETA() {
		return tasks.get(tasks.size() - 1).getEndTime();
	}

}
