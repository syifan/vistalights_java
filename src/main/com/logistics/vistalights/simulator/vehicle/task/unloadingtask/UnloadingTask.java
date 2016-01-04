/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.unloadingtask;

import java.time.Duration;
import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class UnloadingTask implements VehicleTask {
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private UnloadingTaskReserver reserver;
	private UnloadingTaskExecutor executor;

	
	/**
	 * @param startTime
	 * @param endTime
	 */
	public UnloadingTask(LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getStartTime()
	 */
	@Override
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getEndTime()
	 */
	@Override
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#postpone(java.time.Duration)
	 */
	@Override
	public void postpone(Duration amount) {
		startTime = startTime.plus(amount);
		endTime = endTime.plus(amount);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskExecutor()
	 */
	@Override
	public VehicleTaskExecutor getTaskExecutor() {
		return executor;
	}
	
	public void setTaskExecutor(UnloadingTaskExecutor executor) {
		this.executor = executor;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskReserver()
	 */
	@Override
	public TaskReserver getTaskReserver() {
		return reserver;
	}
	
	public void setTaskReserver(UnloadingTaskReserver reserver) {
		this.reserver = reserver;
	}

}
