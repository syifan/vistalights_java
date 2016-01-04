/**
 * Logistics server side
 */
package com.logistics.simulator.network.loader;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.IntersectionCreator;
import com.logistics.simulator.network.node.NodeCreator;
import com.logistics.simulator.network.segment.SegmentCreator;

/**
 * @author yifan
 *
 */
public class NetworkLoaderImpl implements NetworkLoader {
	
	protected NodeCreator nodeCreator;
	protected IntersectionCreator intersectionCreator;
	protected SegmentCreator segmentCreator;

	/**
	 * @param nodeCreator
	 * @param intersectionCreator
	 * @param segmentCreator
	 */
	public NetworkLoaderImpl(
			NodeCreator nodeCreator,
			IntersectionCreator intersectionCreator,
			SegmentCreator segmentCreator) {
		super();
		this.nodeCreator = nodeCreator;
		this.intersectionCreator = intersectionCreator;
		this.segmentCreator = segmentCreator;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.NetworkLoader#LoadNetwork(com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public void loadNetwork(JsonNode json) {
		
		// Load nodes
		for (JsonNode nodeJson : json.get("nodes")) {
			int id = nodeJson.get("id").asInt();
			JsonNode positionNode = nodeJson.get("position");
			double x = positionNode.get("x").asDouble();
			double y = positionNode.get("y").asDouble();
			double z = positionNode.get("z").asDouble();
			Point3D position = new Point3D(x, y, z);
			nodeCreator.createNode(id, position);
		}
		
		// Load segment
		if (json.get("segments") != null) {
			for (JsonNode segmentJson : json.get("segments")) {
				int src = segmentJson.get("src").asInt();
				int dst = segmentJson.get("dst").asInt();
				boolean bidirectional = 
						segmentJson.get("bidirectional").asBoolean();
				segmentCreator.createSegment(src, dst, bidirectional);
			}
		}
		
		// Load intersection
		if (json.get("intersections") != null) {
			for (JsonNode intersectionJson: json.get("intersections")) {
				JsonNode positionNode = intersectionJson.get("position");
				double x = positionNode.get("x").asDouble();
				double y = positionNode.get("y").asDouble();
				double z = positionNode.get("z").asDouble();
				Point3D position = new Point3D(x, y, z);
				Set<Integer> ids = new HashSet<Integer>();
				for (JsonNode id : intersectionJson.get("nodes")) {
					ids.add(id.asInt());
				}
				intersectionCreator.createIntersection(position, ids);
			}
		}
		
	}

}
