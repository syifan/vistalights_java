/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;

import com.logistics.simulator.vehicle.Vehicle;

/**
 * VehicleScheduler is responsible for setting tasks one ship
 * 
 * @author Yifan
 *
 */
public interface VehicleScheduler {
	public Schedule schedule(Vehicle vehicle, LocalDateTime currentTime);
}
