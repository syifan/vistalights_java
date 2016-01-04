/**
 * Logistics server side
 */
package com.logistics.simulator.network.segment;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.reservation.ReservationManager;

/**
 * @author yifan
 *
 */
public class SegmentImpl implements Segment {

	private Node sourceNode;
	private Node destinationNode;
	private boolean bidirectional;
	protected ReservationManager reservationManager;
	

	/**
	 * @param timeSlotFactory
	 */
	public SegmentImpl(ReservationManager reservationManager) {
		super();
		this.reservationManager = reservationManager;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Schedulable#AvailableUnil(java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime availableUntil(LocalDateTime from) {
		return reservationManager.availableUntil(from);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Schedulable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
		return reservationManager.isTimeSlotAvailable(from, to);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Schedulable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public void reserve(LocalDateTime from, LocalDateTime to) {
		reservationManager.reserve(from, to);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Schedulable#clearAllResearvation()
	 */
	@Override
	public void clearAllResearvation() {
		reservationManager.clearAllResearvation();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Schedulable#clearExpiredReservation(java.time.LocalDateTime)
	 */
	@Override
	public void clearExpiredReservation(LocalDateTime currentTime) {
		reservationManager.clearExpiredReservation(currentTime);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.RoadConnection#getDestinations()
	 */
	@Override
	public Set<Node> getDestinations() {
		Set<Node> destinations = new HashSet<Node>(2);
		if (bidirectional) destinations.add(sourceNode);
		destinations.add(destinationNode);
		return destinations;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Segment#getSourceNode()
	 */
	@Override
	public Node getSourceNode() {
		return this.sourceNode;
	}
	
	/**
	 * Set source node
	 */
	public void setSourceNode(Node sourceNode) {
		this.sourceNode = sourceNode;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Segment#getDestinationNode()
	 */
	@Override
	public Node getDestinationNode() {
		return destinationNode;
	}
	
	/**
	 * Set destination node
	 */
	public void setDestinationNode(Node destinationNode) {
		this.destinationNode = destinationNode;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Segment#isBidirectional()
	 */
	@Override
	public boolean isBidirectional() {
		return this.bidirectional;
	}

	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.network.Segment#setBidirectional(boolean)
	 */
	public void setBidirectional(boolean bidirectional) {
		this.bidirectional = bidirectional;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime nextAvailableTime(LocalDateTime from, LocalDateTime to) {
		return reservationManager.nextAvailableTime(from, to);
	}

}
