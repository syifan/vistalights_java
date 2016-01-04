/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.reservation.ReservationManager;
import com.logistics.simulator.network.reservation.ReservationManagerImpl;
import com.logistics.simulator.network.reservation.TimeSlotFactory;
import com.logistics.simulator.network.reservation.TimeSlotImplFactory;

/**
 * @author yifan
 *
 */
public class NodeImplFactory implements NodeFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.NodeFactory#produceNode(com.logistics.shared.Point3D)
	 */
	@Override
	public Node produceNode(int id, Point3D position) {
		TimeSlotFactory timeSlotFactory = new TimeSlotImplFactory();
		ReservationManager reservationManager = 
				new ReservationManagerImpl(timeSlotFactory);
		NodeImpl node = new NodeImpl(id, reservationManager);
		node.setPosition(position);
		return node;
	}

}
