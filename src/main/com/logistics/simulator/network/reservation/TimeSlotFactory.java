/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.LocalDateTime;

/**
 * @author yifan
 *
 */
public interface TimeSlotFactory {
	public TimeSlot produceTimeSlot(LocalDateTime start, LocalDateTime end);
}
