/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.reservation.ReservationManager;

/**
 * @author yifan
 *
 */
public class IntersectionImpl implements Intersection {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.RoadConnection#getDestinations()
	 */
	@Override
	public Set<Node> getDestinations() {
		return destinations;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.network.Intersection#addDestination(com.logistics.simulator.network.Node)
	 */
	public void addDestination(Node destination) {
		destinations.add(destination);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#AvailableUntil(java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime availableUntil(LocalDateTime from) {
		return reservationManager.availableUntil(from);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
		return reservationManager.isTimeSlotAvailable(from, to);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public void reserve(LocalDateTime from, LocalDateTime to) {
		reservationManager.reserve(from, to);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#clearAllResearvation()
	 */
	@Override
	public void clearAllResearvation() {
		reservationManager.clearAllResearvation();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#clearExpiredReservation(java.time.LocalDateTime)
	 */
	@Override
	public void clearExpiredReservation(LocalDateTime currentTime) {
		reservationManager.clearExpiredReservation(currentTime);
	}
	
	protected Set<Node> destinations = new HashSet<Node>();
	protected ReservationManager reservationManager;
	private Point3D position;
	
	/**
	 * Constructor
	 * @param reservationManager
	 */
	public IntersectionImpl(ReservationManager reservationManager) {
		super();
		this.reservationManager = reservationManager;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Intersection#getPosition()
	 */
	@Override
	public Point3D getPosition() {
		return this.position;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Intersection#setPosition(com.logistics.shared.Point3D)
	 */
	@Override
	public void setPosition(Point3D position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime nextAvailableTime(LocalDateTime from, LocalDateTime to) {
		return reservationManager.nextAvailableTime(from, to);
	}

}
