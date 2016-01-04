/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.reservation.Reservable;

/**
 * A Node is a critical point in the road graph
 * @author yifan
 *
 */
public interface Node extends Reservable {
	
	/**
	 * Return a backup node.
	 * @return
	 */
	public Node getBackupNode();
	
	/**
	 * Return node position
	 * @return
	 */
	public Point3D getPosition();
	
	/**
	 * Add connection
	 * @param connection
	 */
	public void addConnection(RoadConnection connection);
	
	/**
	 * Returns a set of road connection that is connected with current node
	 * @return
	 */
	public Set<RoadConnection> getConnections();
	
	/**
	 * Return node id
	 * @return
	 */
	public int getId();

	/**
	 * Get the connection that connects to a certaion node
	 * @param toNode
	 * @return
	 */
	public RoadConnection getConnection(Node toNode);
}
