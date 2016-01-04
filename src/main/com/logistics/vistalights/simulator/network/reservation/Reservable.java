/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.LocalDateTime;

/**
 * A Achedulable is a resources that the future time slot can be reserved.
 * @author yifan
 *
 */
public interface Reservable {
	/**
	 * Given a time to start, returns what is the time that the resource will
	 * be occupied again.
	 * @param from
	 * @return
	 */
	public LocalDateTime availableUntil(LocalDateTime from);
	
	/**
	 * Find next schedulable time
	 * @param from
	 * @param to
	 * @return
	 */
	public LocalDateTime nextAvailableTime(LocalDateTime from, 
			LocalDateTime to);
	
	/**
	 * Checks if a desired time is available or not.
	 * @param from
	 * @param end
	 * @return
	 */
	public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to);
	
	/**
	 * Reserve the time from "from" to "to"
	 * @param from
	 * @param end
	 */
	public void reserve(LocalDateTime from, LocalDateTime to);
	
	/**
	 * Clear all the reserved time on this scheduable
	 */
	public void clearAllResearvation();
	
	/**
	 * Remove all the reserved time slots before "currentTime"
	 * @param currentTime
	 */
	public void clearExpiredReservation(LocalDateTime currentTime);
	
	
}
