/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import java.time.Duration;
import java.time.LocalDateTime;

import com.logistics.shared.Point3D;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.Vehicle;

/**
 * The pilot that simply moves the ship forward
 * @author yifan
 *
 */
public class ForwardMovingPilot implements Pilot {

	private Vehicle vehicle;
	private Scheduler scheduler;
	private double speed = 3.0;
	private double turnSpeed = 0.003;
	private Point3D destination;

	/**
	 * @param vehicle
	 * @param scheduler
	 */
	public ForwardMovingPilot(Vehicle vehicle, Scheduler scheduler) {
		this.vehicle = vehicle;
		this.scheduler = scheduler;
	}
	
	/**
	 * Move a certain distance towards a particular target
	 * @param nextPoint
	 * @param distance
	 */
	private void moveToward(Point3D target, double distance)
	{
		if (distance == 0) return;
		Point3D vector = target.subtract(vehicle.getPosition());
		Point3D moveVector = vector.normalize().multiply(distance);
		vehicle.setPosition(vehicle.getPosition().add(moveVector));
	}
	
	/**
	 * 
	 * @param target
	 * @param maxAngleCanTurn
	 */
	private void turnToward(Point3D target, double maxAngleCanTurn) {
		Point3D vector = target.subtract(vehicle.getPosition());
		double angleDiff = vector.angle(vehicle.getHeading());
		double turnAngle;
		if  (Double.isNaN(angleDiff)) {
			turnAngle = 0.2;
		} else if (angleDiff > maxAngleCanTurn) {
			turnAngle = maxAngleCanTurn;
		} else {
			turnAngle = angleDiff;
		}
		
		if (vector.crossProduct(vehicle.getHeading()).getZ() < 0) {
			vehicle.setHeading(vehicle.getHeading().rotateZ(turnAngle));
		} else {
			vehicle.setHeading(vehicle.getHeading().rotateZ(-turnAngle));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.Pilot#moveVehicle()
	 */
	@Override
	public void moveVehicle() {
		// Get the maximum distance can move
		double timeElapsed = scheduler.getVirtualTimeElapsed();
		double moveDistance = timeElapsed * speed;
		double angleCanTurn = timeElapsed * turnSpeed;
		
		// Move towards destination
		if (destination == null) return;
		double distance = vehicle.getPosition().distanceTo(destination);
		if (distance > moveDistance) {
			moveToward(destination, moveDistance);
		} else {
			moveToward(destination, distance);
			moveDistance -= distance;
			destination = null;
		}
			
		// Turn
		if (destination != null) {
			this.turnToward(destination, angleCanTurn);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.Pilot#setDestination(com.logistics.shared.Point3D)
	 */
	@Override
	public void setDestination(Point3D destination, LocalDateTime dueTime) {
		this.destination = destination;
		
		// Calculated required speed
		Duration time = Duration.between(scheduler.getVirtualTime(), dueTime);
		double timeInSec = time.toNanos() / 1e9;
		double distance = this.destination.distanceTo(vehicle.getPosition());
		speed = distance / timeInSec;
	}


}
