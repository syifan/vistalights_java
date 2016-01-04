/**
 * Logistics server side
 */
package com.logistics.simulator.network.segment;

import com.logistics.simulator.network.reservation.ReservationManager;
import com.logistics.simulator.network.reservation.ReservationManagerImpl;
import com.logistics.simulator.network.reservation.TimeSlotFactory;
import com.logistics.simulator.network.reservation.TimeSlotImplFactory;

/**
 * @author yifan
 *
 */
public class SegmentImplFactory implements SegmentFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.SegmentFactory#produceSegment(com.logistics.simulator.network.Node, com.logistics.simulator.network.Node, boolean)
	 */
	@Override
	public Segment produceSegment() {
		TimeSlotFactory timeSlotFactory = new TimeSlotImplFactory();
		ReservationManager reservationManager = 
				new ReservationManagerImpl(timeSlotFactory);
		SegmentImpl segment = new SegmentImpl(reservationManager);
		return segment;
	}

}
