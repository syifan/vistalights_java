/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.LocalDateTime;

/**
 * @author yifan
 *
 */
public class TimeSlotImpl implements TimeSlot {
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	/**
	 * @param start
	 * @param end
	 */
	public TimeSlotImpl(LocalDateTime start, LocalDateTime end) {
		this.startTime = start;
		this.endTime = end;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.TimeSlot#getStartTime()
	 */
	@Override
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.TimeSlot#getEndTime()
	 */
	@Override
	public LocalDateTime getEndTime() {
		return endTime;
	}

}
