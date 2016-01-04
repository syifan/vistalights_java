/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yifan
 *
 */
public class ReservationManagerImpl implements ReservationManager {
	protected Set<TimeSlot> reservedTimeSlot = new HashSet<TimeSlot>();
	protected TimeSlotFactory timeSlotFactory;
	
	/**
	 * @param timeSlotImplFactory
	 */
	public ReservationManagerImpl(TimeSlotFactory timeSlotFactory) {
		this.timeSlotFactory = timeSlotFactory;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#AvailableUntil(java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime availableUntil(LocalDateTime from) {
		// Check if from time is available
		synchronized(reservedTimeSlot) {
			for (TimeSlot timeSlot : reservedTimeSlot) {
				if (from.isAfter(timeSlot.getStartTime()) &&
						from.isBefore(timeSlot.getEndTime())) {
					return from;
				}
			}
		}
		
		// Next scheduled time
		LocalDateTime nextScheduledTime = null;
		synchronized(reservedTimeSlot) {
			for(TimeSlot timeSlot : reservedTimeSlot) {
				if (timeSlot.getStartTime().isAfter(from)) {
					if(nextScheduledTime == null) {
						nextScheduledTime = timeSlot.getStartTime();
					} else if (timeSlot.getStartTime().isBefore(
							nextScheduledTime)){
						nextScheduledTime = timeSlot.getStartTime();
					}
				}
			}
		}
		return nextScheduledTime;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
		synchronized(reservedTimeSlot) {
			for (TimeSlot timeSlot : reservedTimeSlot) {
				LocalDateTime start = timeSlot.getStartTime();
				LocalDateTime end = timeSlot.getEndTime();
				if (
					(from.compareTo(start) >= 0 && from.compareTo(end) <= 0) ||
					(to.compareTo(start) >= 0 && to.compareTo(end) <= 0) ||
					(from.compareTo(start) <= 0 && to.compareTo(end) >= 0) ||
					(from.compareTo(start) >= 0 && to.compareTo(end) <= 0)
				) {
					return false;
				}
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public void reserve(LocalDateTime from, LocalDateTime to) {
		synchronized(reservedTimeSlot) {
			reservedTimeSlot.add(timeSlotFactory.produceTimeSlot(from, to));
		}

	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#clearAllResearvation()
	 */
	@Override
	public void clearAllResearvation() {
		synchronized(reservedTimeSlot) {
			this.reservedTimeSlot.clear();
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#clearExpiredReservation(java.time.LocalDateTime)
	 */
	@Override
	public void clearExpiredReservation(LocalDateTime currentTime) {
		synchronized(reservedTimeSlot) {
			Iterator<TimeSlot> it = reservedTimeSlot.iterator();
			while(it.hasNext()) {
				TimeSlot timeSlot = it.next();
				if (timeSlot.getEndTime().compareTo(currentTime) <= 0) {
					it.remove();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime nextAvailableTime(LocalDateTime from, LocalDateTime to) {
		if (isTimeSlotAvailable(from, to)) {
			return from;
		}
		LocalDateTime earliestTime = LocalDateTime.MAX;
		Duration duration = Duration.between(from, to);
		for (TimeSlot slot : reservedTimeSlot) {
			if (slot.getEndTime().compareTo(from) < 0) continue;
			LocalDateTime startTime = slot.getEndTime().plusSeconds(1);
			LocalDateTime endTime = startTime.plus(duration);
			if (isTimeSlotAvailable(startTime, endTime)) {
				if (earliestTime.isAfter(startTime)) {
					earliestTime = startTime;
				}
			}
		}
		
		if (earliestTime.equals(LocalDateTime.MAX)) {
			System.out.println(earliestTime);
		}
		return earliestTime;
	}

}
