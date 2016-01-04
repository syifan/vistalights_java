/**
 * Logistics server side
 */
package com.logistics.simulator.network.segment;

import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.reservation.Reservable;

/**
 * A Segment is a connection between nodes. The ship scheduler schedules ships 
 * to guarantee that no two ships will occupy the same segment at the same time.
 * 
 * @author yifan
 *
 */
public interface Segment extends Reservable, RoadConnection{ 
	/**
	 * Get the source node
	 * @return
	 */
	public Node getSourceNode();
	
	public void setSourceNode(Node node);
	
	/**
	 * Get the destination node
	 * @return
	 */
	public Node getDestinationNode();
	
	public void setDestinationNode(Node node);
	
	/**
	 * Checks if the segment allows a bidirectional segment
	 * @return
	 */
	public boolean isBidirectional();
	
	/**
	 * Set if the segment is bidirectional
	 * @param bidirectional
	 */
	public void setBidirectional(boolean bidirectional);
}
