/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task;

import java.time.LocalDateTime;

/**
 * @author Yifan
 *
 */
public interface TaskReserver {
	public boolean hasConflict();
	public LocalDateTime nextNoConflictTime();
	public void makeReservation();
}
