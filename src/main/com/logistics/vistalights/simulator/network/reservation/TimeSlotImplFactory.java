/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.LocalDateTime;

/**
 * @author yifan
 *
 */
public class TimeSlotImplFactory implements TimeSlotFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.TimeSlotFactory#produceTimeSlot(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public TimeSlot produceTimeSlot(LocalDateTime start, LocalDateTime end) {
		return new TimeSlotImpl(start, end);
	}

}
