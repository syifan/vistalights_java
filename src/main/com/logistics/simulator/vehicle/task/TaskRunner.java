/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task;

import com.logistics.simulator.vehicle.scheduler.Schedule;

/**
 * @author Yifan
 *
 */
public interface TaskRunner {
	public void run(Schedule schedule);
}
