/**
 * Logistics server side
 */
package com.logistics.simulator.network;

import java.util.Map;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.Intersection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.segment.Segment;

/**
 * The network is a graph representation of the road system. 
 * @author yifan
 *
 */
public interface Network {
	
	/**
	 * Returns the nearest node in the network given a point on the map
	 * @param point
	 * @return
	 */
	public Node getNearestNode(Point3D point);
	
	/**
	 * Add a into the network
	 */
	public void addNode(Node node);
	
	/**
	 * Get all the nodes in the network
	 * @return
	 */
	public Map<Integer, Node> getNodes();
	
	/**
	 * Get node by id
	 */
	public Node getNodeById(int id);
	
	/**
	 * Add an segment to the network
	 * @param segment
	 */
	public void addSegment(Segment segment, int sourceId, int destinationId, 
			boolean bidirectional);
	
	/**
	 * Add an intersection to the network
	 * @param intersection
	 */
	public void addIntersection(Intersection intersection,
			Set<Integer> destinationIds);
}
