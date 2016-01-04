/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.Duration;
import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;

/**
 * @author Yifan
 *
 */
public class ConflictResolverImpl implements ConflictResolver {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.ConflictResolver#resolve(com.logistics.simulator.vehicle.Schedule)
	 */
	@Override
	public void resolve(Schedule schedule) {
		boolean hasConflict = true;
		while(hasConflict) {
			hasConflict = false;
			Duration longestDuration = Duration.ZERO;
			for (VehicleTask task : schedule.getTasks()) {
				TaskReserver reserver = task.getTaskReserver();
				LocalDateTime nextAvailableTime = 
						reserver.nextNoConflictTime();
				Duration duration = Duration.between(task.getStartTime(), 
						nextAvailableTime);
				if (!duration.isZero()) {
					hasConflict = true;
					if (duration.compareTo(longestDuration) > 0) {
						longestDuration = duration;
					}
				}
			}
			
			// Has conflict
			if (hasConflict) {
				for (VehicleTask task : schedule.getTasks()) {
					task.postpone(longestDuration);
				}
			}
		}

	}

}
