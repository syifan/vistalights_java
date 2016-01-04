/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Yifan
 *
 */
public interface VehicleTask {
	public LocalDateTime getStartTime();
	public LocalDateTime getEndTime();
	public void postpone(Duration amount);
	
	public VehicleTaskExecutor getTaskExecutor();
	public TaskReserver getTaskReserver();
}
