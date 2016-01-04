/**
 * Logistics server side
 */
package com.logistics.simulator.network;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.Intersection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.segment.Segment;

/**
 * @author yifan
 *
 */
public class NetworkImpl implements Network {
	
	protected Map<Integer, Node> nodes = new HashMap<Integer, Node>();

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#getNearestNode(com.logistics.shared.Point3D)
	 */
	@Override
	public Node getNearestNode(Point3D point) {
		double minimumDistance = Double.MAX_VALUE;
		Node nearestNode = null;
		for (Map.Entry<Integer, Node> pair : nodes.entrySet()) {
			Node node = pair.getValue();
			double distance = node.getPosition().distanceTo(point);
			if (distance < minimumDistance) {
				minimumDistance = distance;
				nearestNode = node;
			}
		}
		return nearestNode;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#addNode(com.logistics.simulator.network.Node)
	 */
	@Override
	public void addNode(Node node) {
		nodes.put(node.getId(), node);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#getNodes()
	 */
	@Override
	public Map<Integer, Node> getNodes() {
		return nodes;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#getNodesById(int)
	 */
	@Override
	public Node getNodeById(int id) {
		return nodes.get(id);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#addSegment(int, int, boolean)
	 */
	@Override
	public void addSegment(Segment segment, int sourceId, int destinationId,
			boolean bidirectional) {
		Node sourceNode = getNodeById(sourceId);
		Node destinationNode = getNodeById(destinationId);
		if (sourceNode == null || destinationNode == null) {
			return;
		}
		segment.setSourceNode(sourceNode);
		segment.setDestinationNode(destinationNode);
		segment.setBidirectional(bidirectional);
		sourceNode.addConnection(segment);
		if (bidirectional) {
			destinationNode.addConnection(segment);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.Network#addIntersection(java.util.Set)
	 */
	@Override
	public void addIntersection(Intersection intersection,
			Set<Integer> destinationIds) {
		for (Integer id : destinationIds) {
			Node node = getNodeById(id);
			intersection.addDestination(node);
			node.addConnection(intersection);
		}
		
	}

}
