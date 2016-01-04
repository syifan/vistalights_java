/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.movetask;

import java.time.LocalDateTime;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface Pilot {
	
	/**
	 * Move the vehicle
	 */
	public void moveVehicle();

	/**
	 * @param destination
	 * @param duetime
	 */
	void setDestination(Point3D destination, LocalDateTime duetime);
}
