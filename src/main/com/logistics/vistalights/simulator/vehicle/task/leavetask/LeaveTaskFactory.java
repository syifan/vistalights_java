/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.leavetask;

import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.Vehicle;

/**
 * @author Yifan
 *
 */
public interface LeaveTaskFactory {
	public LeaveTask produceLeaveTask(LocalDateTime time, Vehicle vehicle);
}
