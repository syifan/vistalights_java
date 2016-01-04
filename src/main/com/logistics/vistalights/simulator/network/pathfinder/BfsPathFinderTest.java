/**
 * Logistics server side
 */
package com.logistics.simulator.network.pathfinder;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.NetworkImpl;
import com.logistics.simulator.network.intersection.IntersectionImpl;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.node.NodeImpl;
import com.logistics.simulator.network.segment.SegmentImpl;
import com.logistics.simulator.vehicle.scheduler.path.Path;

/**
 * @author Yifan
 *
 */
public class BfsPathFinderTest {

	/**
	 * Test method for {@link com.logistics.simulator.network.pathfinder.BfsPathFinder#findPath(int, int)}.
	 */
	@Test
	public void testFindPath() {
		// Create a network
		Network network = new NetworkImpl();
		network.addNode(new NodeImpl(1, null));
		network.addNode(new NodeImpl(2, null));
		network.addNode(new NodeImpl(3, null));
		network.addNode(new NodeImpl(4, null));
		network.addNode(new NodeImpl(5, null));
		network.addNode(new NodeImpl(6, null));
		network.addNode(new NodeImpl(7, null));
		network.addNode(new NodeImpl(8, null));
		network.addSegment(new SegmentImpl(null), 1, 2, true);
		network.addSegment(new SegmentImpl(null), 2, 3, false);
		network.addSegment(new SegmentImpl(null), 1, 4, true);
		network.addSegment(new SegmentImpl(null), 4, 2, true);
		network.addSegment(new SegmentImpl(null), 4, 5, false);
		network.addSegment(new SegmentImpl(null), 5, 3, false);
		network.addSegment(new SegmentImpl(null), 1, 6, false);
		network.addSegment(new SegmentImpl(null), 7, 5, false);
		network.addSegment(new SegmentImpl(null), 8, 3, false);
		Set<Integer> intersectionDestIds = new HashSet<Integer>();
		intersectionDestIds.add(6);
		intersectionDestIds.add(7);
		intersectionDestIds.add(8);
		network.addIntersection(new IntersectionImpl(null), 
				intersectionDestIds);
		
		// Create pathfinder
		PathFinder pathFinder = new BfsPathFinder(network);
		Set<Path> paths = pathFinder.findPath(1, 3);
		
		// Assertion
		assertEquals(8, paths.size());
		
	}

}
