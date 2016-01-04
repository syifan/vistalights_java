/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import java.time.Duration;
import java.time.LocalDateTime;

import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class MoveVehicleTask implements VehicleTask {
	
	protected boolean conflict = false;
	protected RoadConnection connection;
	protected Node destination;
	protected LocalDateTime endTime;
	protected MoveVehicleTaskExecutor executor = null;
	protected LocalDateTime noConflictTime;
	protected MoveVehicleTaskReserver reserver = null;
	protected LocalDateTime startTime;

	/**
	 * @return the segment
	 */
	public RoadConnection getConnection() {
		return connection;
	}

	/**
	 * @return the destination
	 */
	public Node getDestination() {
		return destination;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getEndTime()
	 */
	@Override
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getStartTime()
	 */
	@Override
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskRunner()
	 */
	@Override
	public VehicleTaskExecutor getTaskExecutor() {
		return this.executor;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskReserver()
	 */
	@Override
	public TaskReserver getTaskReserver() {
		return this.reserver;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTask#postpone(java.time.Duration)
	 */
	@Override
	public void postpone(Duration amount) {
		this.startTime = this.startTime.plus(amount);
		this.endTime = this.endTime.plus(amount);
	}

	/**
	 * @param segment the segment to set
	 */
	public void setConnection(RoadConnection connection) {
		this.connection = connection;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Node destination) {
		this.destination = destination;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @param executor the executor to set
	 */
	public void setExecutor(MoveVehicleTaskExecutor executor) {
		this.executor = executor;
	}

	/**
	 * @param reserver the reserver to set
	 */
	public void setReserver(MoveVehicleTaskReserver reserver) {
		this.reserver = reserver;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

}
