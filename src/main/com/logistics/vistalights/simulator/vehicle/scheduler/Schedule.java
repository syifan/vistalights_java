/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import com.logistics.simulator.vehicle.task.VehicleTask;

/**
 * @author Yifan
 *
 */
public interface Schedule {
	public List<VehicleTask> getTasks();
	public void addTask(VehicleTask task);
	public LocalDateTime getETA();
}
