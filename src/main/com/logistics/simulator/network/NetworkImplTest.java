/**
 * Logistics server side
 */
package com.logistics.simulator.network;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.Intersection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.segment.Segment;

/**
 * @author yifan
 *
 */
public class NetworkImplTest {
	
	class MockupNode implements Node {
		
		protected int id;
		protected Point3D position;
		protected Set<RoadConnection> connections = 
				new HashSet<RoadConnection>();

		/**
		 * @param id
		 * @param position
		 */
		public MockupNode(int id, Point3D position) {
			super();
			this.id = id;
			this.position = position;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Node#getBackupNode()
		 */
		@Override
		public Node getBackupNode() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Node#getPosition()
		 */
		@Override
		public Point3D getPosition() {
			return position;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Node#addConnection(com.logistics.simulator.network.RoadConnection)
		 */
		@Override
		public void addConnection(RoadConnection connection) {
			this.connections.add(connection);
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
		 * @see com.logistics.simulator.network.Node#getConnection(com.logistics.simulator.network.Node)
		 */
		@Override
		public RoadConnection getConnection(Node toNode) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#availableUntil(java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime availableUntil(LocalDateTime from) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime nextAvailableTime(LocalDateTime from,
				LocalDateTime to) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public void reserve(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearAllResearvation()
		 */
		@Override
		public void clearAllResearvation() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearExpiredReservation(java.time.LocalDateTime)
		 */
		@Override
		public void clearExpiredReservation(LocalDateTime currentTime) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MockupSegment implements Segment {
		
		protected boolean bidirectional;
		protected Node src;
		protected Node dst;

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#AvailableUntil(java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime availableUntil(LocalDateTime from) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public void reserve(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearAllResearvation()
		 */
		@Override
		public void clearAllResearvation() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearExpiredReservation(java.time.LocalDateTime)
		 */
		@Override
		public void clearExpiredReservation(LocalDateTime currentTime) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.RoadConnection#getDestinations()
		 */
		@Override
		public Set<Node> getDestinations() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#getSourceNode()
		 */
		@Override
		public Node getSourceNode() {
			return src;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#getDestinationNode()
		 */
		@Override
		public Node getDestinationNode() {
			return dst;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#isBidirectional()
		 */
		@Override
		public boolean isBidirectional() {
			return bidirectional;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#setBidirectional(boolean)
		 */
		@Override
		public void setBidirectional(boolean bidirectional) {
			this.bidirectional = bidirectional;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#setSourceNode(com.logistics.simulator.network.Node)
		 */
		@Override
		public void setSourceNode(Node node) {
			this.src = node;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Segment#setDestinationNode(com.logistics.simulator.network.Node)
		 */
		@Override
		public void setDestinationNode(Node node) {
			this.dst = node;
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime nextAvailableTime(LocalDateTime from,
				LocalDateTime to) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class MockupIntersection implements Intersection {
		
		protected Set<Node> destinations = new HashSet<Node>();

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.RoadConnection#getDestinations()
		 */
		@Override
		public Set<Node> getDestinations() {
			return destinations;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#AvailableUntil(java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime availableUntil(LocalDateTime from) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public boolean isTimeSlotAvailable(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#reserve(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public void reserve(LocalDateTime from, LocalDateTime to) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearAllResearvation()
		 */
		@Override
		public void clearAllResearvation() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#clearExpiredReservation(java.time.LocalDateTime)
		 */
		@Override
		public void clearExpiredReservation(LocalDateTime currentTime) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Intersection#getPosition()
		 */
		@Override
		public Point3D getPosition() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Intersection#setPosition(com.logistics.shared.Point3D)
		 */
		@Override
		public void setPosition(Point3D position) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Intersection#addDestination(com.logistics.simulator.network.Node)
		 */
		@Override
		public void addDestination(Node node) {
			this.destinations.add(node);
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.network.Reservable#nextAvailableTime(java.time.LocalDateTime, java.time.LocalDateTime)
		 */
		@Override
		public LocalDateTime nextAvailableTime(LocalDateTime from,
				LocalDateTime to) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.NetworkImpl#getNearestNode(com.logistics.shared.Point3D)}.
	 */
	@Test
	public void testGetNearestNode() {
		Point3D point1 = new Point3D(1, 1, 1);
		Point3D point2 = new Point3D(2, 2, 2);
		Point3D point3 = new Point3D(3, 3, 3);
		MockupNode node1 = new MockupNode(1, point1);
		MockupNode node2 = new MockupNode(2, point2);
		MockupNode node3 = new MockupNode(3, point3);
		Network network = new NetworkImpl();
		network.addNode(node1);
		network.addNode(node2);
		network.addNode(node3);
		
		Node nearestNode = network.getNearestNode(new Point3D(0, 0, 0));
		assertEquals(node1, nearestNode);
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.NetworkImpl#addNode(com.logistics.simulator.network.node.Node)}.
	 */
	@Test
	public void testAddNode() {
		Point3D point1 = new Point3D(1, 1, 1);
		Point3D point2 = new Point3D(2, 2, 2);
		MockupNode node1 = new MockupNode(1, point1);
		MockupNode node2 = new MockupNode(2, point2);
		Network network = new NetworkImpl();
		
		// Add one node
		network.addNode(node1);
		Map<Integer, Node> set = network.getNodes();
		assertEquals(1, set.size());
		
		// Add another node
		network.addNode(node2);
		set = network.getNodes();
		assertEquals(2, set.size());
		
		// Get node by id
		Node node3 = network.getNodeById(1);
		assertEquals(node1, node3);
	}
	
	/**
	 * Test method for {@link com.logistics.simulator.network.NetworkImpl#addSegment(com.logistics.simulator.network.segment.Segment, int, int, boolean)}.
	 */
	@Test
	public void testAddSegment() {
		MockupSegment segment = new MockupSegment();
		Network network = new NetworkImpl();
		Point3D point1 = new Point3D(1, 1, 1);
		Point3D point2 = new Point3D(2, 2, 2);
		MockupNode node1 = new MockupNode(1, point1);
		MockupNode node2 = new MockupNode(2, point2);
		network.addNode(node1);
		network.addNode(node2);
		
		// Add an bidirectional segment
		network.addSegment(segment, 1, 2, true);
		assertEquals(1, node1.connections.size());
		assertEquals(1, node2.connections.size());
		assertEquals(node1, segment.getSourceNode());
		assertEquals(node2, segment.getDestinationNode());
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.NetworkImpl#addIntersection(com.logistics.simulator.network.intersection.Intersection, java.util.Set)}.
	 */
	@Test
	public void testAddIntersection() {
		MockupIntersection intersection = new MockupIntersection();
		Network network = new NetworkImpl();
		Point3D point1 = new Point3D(1, 1, 1);
		Point3D point2 = new Point3D(2, 2, 2);
		Point3D point3 = new Point3D(3, 3, 3);
		MockupNode node1 = new MockupNode(1, point1);
		MockupNode node2 = new MockupNode(2, point2);
		MockupNode node3 = new MockupNode(3, point3);
		network.addNode(node1);
		network.addNode(node2);
		network.addNode(node3);
		
		// Add intersection
		Set<Integer> destinationIds = new HashSet<Integer>();
		destinationIds.add(1);
		destinationIds.add(2);
		destinationIds.add(3);
		network.addIntersection(intersection, destinationIds);
		
		// Assertion
		assertEquals(1, node1.connections.size());
		assertEquals(1, node2.connections.size());
		assertEquals(1, node3.connections.size());
		assertEquals(3, intersection.destinations.size());
		
	}

}
