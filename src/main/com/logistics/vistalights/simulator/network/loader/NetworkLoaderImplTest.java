/**
 * Logistics server side
 */
package com.logistics.simulator.network.loader;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.IntersectionCreator;
import com.logistics.simulator.network.node.NodeCreator;
import com.logistics.simulator.network.segment.SegmentCreator;

/**
 * @author yifan
 *
 */
public class NetworkLoaderImplTest {

	/**
	 * Test method for {@link com.logistics.simulator.network.NetworkLoadImpl#LoadNetwork(com.fasterxml.jackson.databind.JsonNode)}.
	 */
	@Test
	public void testLoadNetwork() {
		class MockupNodeCreator implements NodeCreator {
			protected int involkTime = 0;
			/* (non-Javadoc)
			 * @see com.logistics.simulator.network.NodeCreator#createNode(int, com.logistics.shared.Point3D)
			 */
			@Override
			public void createNode(int id, Point3D position) {
				involkTime++;
			}
		}
	
		class MockupIntersectionCreator implements IntersectionCreator {
			protected int involkTime = 0;
			/* (non-Javadoc)
			 * @see com.logistics.simulator.network.IntersectionCreator#createIntersection(com.logistics.shared.Point3D, java.util.Set)
			 */
			@Override
			public void createIntersection(Point3D position, 
					Set<Integer> connectedNodeId) {
				involkTime++;
			}
		}
		
		class MockupSegmentCreator implements SegmentCreator {
			protected int involkTime = 0;
			/* (non-Javadoc)
			 * @see com.logistics.simulator.network.SegmentCreator#createSegment(com.logistics.simulator.network.Node, com.logistics.simulator.network.Node, boolean)
			 */
			@Override
			public void createSegment(int sourceId, int destinationId, 
					boolean bidirectional) {
				involkTime++;
			}
		}
		
		// Mockup components
		MockupNodeCreator nodeCreator = new MockupNodeCreator();
		MockupIntersectionCreator intersectionCreator = 
				new MockupIntersectionCreator();
		MockupSegmentCreator segmentCreator = new MockupSegmentCreator();
		
		// JSON string
		String json = 
				  "{"
				+ "  \"nodes\": ["
				+ "    {"
				+ "      \"id\":1,"
				+ "      \"position\": {\"x\":0,\"y\":0,\"z\":0}"
				+ "    },"
				+ "    {"
				+ "      \"id\":2,"
				+ "      \"position\": {\"x\":100,\"y\":100,\"z\":0}"
				+ "    },"
				+ "    {"
				+ "      \"id\":3,"
				+ "      \"position\": {\"x\":200,\"y\":200,\"z\":0}"
				+ "    }"
				+ "  ],"
				+ "  \"segments\": ["
				+ "    {\"src\": 1, \"dst\": 2, \"bidirectional\":false},"
				+ "    {\"src\": 2, \"dst\": 3, \"bidirectional\":true}"
				+ "  ],"
				+ "  \"intersections\": ["
				+ "    {"
				+ "      \"nodes\": [1, 2, 3],"
				+ "      \"position\": {\"x\":0,\"y\":0,\"z\":0}"
				+ "    }"
				+ "  ]"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mapJson = null;
		try {
			mapJson = mapper.readValue(json.getBytes(), JsonNode.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		NetworkLoaderImpl networkLoader = new NetworkLoaderImpl(
				nodeCreator, intersectionCreator, segmentCreator);
		networkLoader.loadNetwork(mapJson);
		
		// Assert number of object created
		assertEquals(3, nodeCreator.involkTime);
		assertEquals(2, segmentCreator.involkTime);
		assertEquals(1, intersectionCreator.involkTime);
		
	}

}
