/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.reservation.ReservationManager;

/**
 * @author yifan
 *
 */
public class NodeImpl implements Node {
	
	protected Set<RoadConnection> connections = new HashSet<RoadConnection>();
	private int id;
	protected Point3D position;
	protected ReservationManager reservationManager;

	/**
	 * Constructor
	 */
	public NodeImpl(int id, ReservationManager reservationManager){
		this.id = id;
		this.reservationManager = reservationManager;
	}
	
	/**
	 * Add an connection to the road
	 * @param connection
	 */
	public void addConnection(RoadConnection connection) {
		connections.add(connection);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Node#getBackupNode()
	 */
	@Override
	public Node getBackupNode() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Node#getConnections()
	 */
	@Override
	public Set<RoadConnection> getConnections() {
		return connections;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Node#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Node#getPosition()
	 */
	@Override
	public Point3D getPosition() {
		return position;
	}
	/**
	 * Set position
	 * @param position
	 */
	public void setPosition(Point3D position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Node#getConnection(com.logistics.simulator.network.Node)
	 */
	@Override
	public RoadConnection getConnection(Node toNode) {
		for (RoadConnection connection : connections) {
			for (Node node : connection.getDestinations()) {
				if (node == toNode) {
					return connection;
				} 
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#availableUntil(java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime availableUntil(LocalDateTime from) {
		return reservationManager.availableUntil(from);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
	 */
	@Override
	public LocalDateTime nextAvailableTime(LocalDateTime from, LocalDateTime to) {
		return reservationManager.nextAvailableTime(from, to);
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

}
