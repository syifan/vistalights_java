/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.LocalDateTime;

/**
 * @author yifan
 *
 */
public interface TimeSlot {
	/**
	 * Get the start time
	 * @return
	 */
	public LocalDateTime getStartTime();
	
	/**
	 * Get the end time
	 * @return
	 */
	public LocalDateTime getEndTime();
}
