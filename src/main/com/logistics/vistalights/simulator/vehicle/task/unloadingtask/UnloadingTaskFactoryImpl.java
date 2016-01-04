/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.unloadingtask;

import java.time.LocalDateTime;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.cargo.CargoScoreCounter;

/**
 * @author Yifan
 *
 */
public class UnloadingTaskFactoryImpl implements UnloadingTaskFactory {

	/**
	 */
	public UnloadingTaskFactoryImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.UnloadingTaskFactory#produceUnloadingTask()
	 */
	@Override
	public UnloadingTask produceUnloadingTask(
			LocalDateTime startTime, LocalDateTime endTime,
			Node node, CargoScoreCounter cargoScoreCounter) {
		UnloadingTask task = new UnloadingTask(startTime, endTime);
		UnloadingTaskReserver reserver = new UnloadingTaskReserver(node, task);
		task.setTaskReserver(reserver);
		UnloadingTaskExecutor executor = new UnloadingTaskExecutor(
				cargoScoreCounter);
		task.setTaskExecutor(executor);
		return task;
	}

}
