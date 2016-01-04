/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.scheduler.path.Path;
import com.logistics.simulator.vehicle.task.leavetask.LeaveTask;
import com.logistics.simulator.vehicle.task.leavetask.LeaveTaskFactory;
import com.logistics.simulator.vehicle.task.movetask.MoveVehicleTask;
import com.logistics.simulator.vehicle.task.movetask.MoveVehicleTaskFactory;
import com.logistics.simulator.vehicle.task.unloadingtask.UnloadingTask;
import com.logistics.simulator.vehicle.task.unloadingtask.UnloadingTaskFactory;

/**
 * @author Yifan
 *
 */
public class ScheduleCreatorImpl implements ScheduleCreator {
	private Network network;
	private ScheduleFactory scheduleFactory;
	private MoveVehicleTaskFactory moveVehicleTaskFactory;
	private UnloadingTaskFactory unloadingTaskFactory;
	private LeaveTaskFactory leaveTaskFactory;
	
	private boolean unloadingTaskCreated = false;

	/**
	 * @param network
	 * @param vehicle
	 */
	public ScheduleCreatorImpl(
			Network network,
			ScheduleFactory scheduleFactory,
			MoveVehicleTaskFactory moveVehicleTaskFactory,
			UnloadingTaskFactory unloadingTaskFactory,
			LeaveTaskFactory leaveTaskFactory) {
		super();
		this.network = network;
		this.scheduleFactory = scheduleFactory;
		this.moveVehicleTaskFactory = moveVehicleTaskFactory;
		this.unloadingTaskFactory = unloadingTaskFactory;
		this.leaveTaskFactory = leaveTaskFactory;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.ScheduleCreator#createSchedule()
	 */
	@Override
	public Schedule createSchedule(Vehicle vehicle, Path path, 
			LocalDateTime currentTime) {
		unloadingTaskCreated = false;
		// Create schedule
		Schedule schedule = scheduleFactory.produceSchedule();
		
		// Current position
		Point3D currentPosition = vehicle.getPosition();
		Node nearestNode = network.getNearestNode(currentPosition);
		
		// First, goes to nearest node
		if (!nearestNode.getPosition().equals(currentPosition)) {
			double travelTimeInSec = nearestNode.getPosition()
					.distanceTo(currentPosition) / vehicle.getSpeed();
			LocalDateTime endTime = currentTime.plusNanos(
					(long) (travelTimeInSec * 1e9));
			MoveVehicleTask task = moveVehicleTaskFactory.
					produceMoveVehicleTask(vehicle, currentTime, endTime, 
							nearestNode, null);
			schedule.addTask(task);
			currentTime = endTime;
		}
		
		// Second, traverse all nodes on path
		while(path.size() > 1) {
			Node fromNode = path.getNode(0);
			
			// Create unloading node
			if (fromNode == network.getNodeById(vehicle.getUnloadNodeId()) &&
					this.unloadingTaskCreated == false) {
				double unloadingSpeed = 
						vehicle.getCargoContainer().getUnloadingSpeed();
				double timeRequired = vehicle.getCargoContainer().getTonnage() 
						/ unloadingSpeed;
				LocalDateTime endTime = currentTime.plusNanos((long) (
						timeRequired * 1e9));
				UnloadingTask unloadingTask = 
						unloadingTaskFactory.produceUnloadingTask(currentTime, 
						endTime, fromNode, 
						vehicle.getCargoContainer().getCargoScoreCounter());
				schedule.addTask(unloadingTask);
				currentTime = endTime;
				this.unloadingTaskCreated = true;
			}
			
			Node toNode = path.getNode(1);
			double distance = fromNode.getPosition().distanceTo(
					toNode.getPosition());
			double travelTimeInSec = distance / vehicle.getSpeed();
			LocalDateTime endTime = currentTime.plusNanos(
					(long) (travelTimeInSec * 1e9));
			RoadConnection connection = fromNode.getConnection(toNode);
			MoveVehicleTask task = moveVehicleTaskFactory
					.produceMoveVehicleTask(vehicle, currentTime, endTime, 
							toNode, connection);
			schedule.addTask(task);
			currentTime = endTime;
			path.removeNode(0);
			
			
		}
		
		// At the end, add an leave task
		LeaveTask task = leaveTaskFactory.produceLeaveTask(currentTime, 
				vehicle);
		schedule.addTask(task);
		return schedule;
	}

}
