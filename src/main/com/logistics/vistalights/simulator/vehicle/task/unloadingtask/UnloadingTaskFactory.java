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
public interface UnloadingTaskFactory {
	public UnloadingTask produceUnloadingTask(LocalDateTime startTime, 
			LocalDateTime endTime, Node node,
			CargoScoreCounter cargoScoreCounter);
}
