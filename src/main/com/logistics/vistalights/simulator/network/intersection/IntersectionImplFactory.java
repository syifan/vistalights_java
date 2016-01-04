/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.reservation.ReservationManager;
import com.logistics.simulator.network.reservation.ReservationManagerImpl;
import com.logistics.simulator.network.reservation.TimeSlotFactory;
import com.logistics.simulator.network.reservation.TimeSlotImplFactory;

/**
 * @author yifan
 *
 */
public class IntersectionImplFactory implements IntersectionFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.IntersectionFactory#produceIntersection()
	 */
	@Override
	public Intersection produceIntersection(Point3D position) {
		TimeSlotFactory timeSlotFactory = new TimeSlotImplFactory();
		ReservationManager reservationManager = 
				new ReservationManagerImpl(timeSlotFactory);
		Intersection intersection = new IntersectionImpl(reservationManager);
		intersection.setPosition(position);
		return intersection;
	}

}
