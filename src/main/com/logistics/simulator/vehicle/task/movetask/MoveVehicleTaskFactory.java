/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import java.time.LocalDateTime;

import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.Vehicle;

/**
 * @author Yifan
 *
 */
public class MoveVehicleTaskFactory {
	private Scheduler scheduler;

	/**
	 * @param vehicle
	 * @param scheduler
	 */
	public MoveVehicleTaskFactory(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}

	public MoveVehicleTask produceMoveVehicleTask(
			Vehicle vehicle,
			LocalDateTime startTime, LocalDateTime endTime, 
			Node destination, RoadConnection connection) {
		MoveVehicleTask moveVehicleTask = new MoveVehicleTask();
		moveVehicleTask.setStartTime(startTime);
		moveVehicleTask.setEndTime(endTime);
		moveVehicleTask.setDestination(destination);
		moveVehicleTask.setConnection(connection);
		
		MoveVehicleTaskReserver taskReserver = new MoveVehicleTaskReserver(
				moveVehicleTask, connection);
		moveVehicleTask.setReserver(taskReserver);
		
		Pilot pilot = new ForwardMovingPilot(vehicle, scheduler);
		MoveVehicleTaskExecutor executor = new MoveVehicleTaskExecutor(
				moveVehicleTask, vehicle, pilot);
		moveVehicleTask.setExecutor(executor);
		return moveVehicleTask;
	}
}
