/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.scheduler.Schedule;

/**
 * @author Yifan
 *
 */
public class TaskRunnerImpl implements TaskRunner {
	Scheduler scheduler;
	
	/**
	 * @param scheduler
	 */
	public TaskRunnerImpl(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.TaskRunner#run()
	 */
	@Override
	public void run(Schedule schedule) {
		if (schedule == null) return;
		List<VehicleTask> tasks = schedule.getTasks();
		if (tasks.isEmpty()) return;
		LocalDateTime currentTime = scheduler.getVirtualTime();
		synchronized (tasks) {
			
			for (Iterator<VehicleTask> it = tasks.iterator(); it.hasNext(); ) {
				VehicleTask task = it.next();
				// Execute task
				if (currentTime.isAfter(task.getStartTime())) {
					VehicleTaskExecutor executor = task.getTaskExecutor();
					if (!executor.isInitiated()) {
						executor.initialize();
					}
					executor.execute();
				} else {
					return;
				}
				// Remove expired tasks
				if (currentTime.isAfter(task.getEndTime())) {
					it.remove();
				}
			}
		}
	}

}
