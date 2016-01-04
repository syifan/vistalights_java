/**
 * Logistics server side
 */
package com.logistics.simulator.network;

import java.util.Set;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.reservation.Reservable;

/**
 * A RoadConnection is an object that connect nodes.
 * @author yifan
 *
 */
public interface RoadConnection extends Reservable {
	/**
	 * Get a list of nodes that this connection connects to
	 * @return
	 */
	public Set<Node> getDestinations();
}
