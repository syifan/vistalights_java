/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.scheduler.path.Path;

/**
 * @author Yifan
 *
 */
public interface ScheduleCreator {
	public Schedule createSchedule(Vehicle vehicle, Path path, 
			LocalDateTime currentTime);
}
