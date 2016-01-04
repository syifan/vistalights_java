/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.NetworkImpl;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.node.NodeImpl;
import com.logistics.simulator.network.segment.SegmentImpl;
import com.logistics.simulator.vehicle.VehicleImpl;
import com.logistics.simulator.vehicle.scheduler.path.Path;
import com.logistics.simulator.vehicle.scheduler.path.PathImpl;
import com.logistics.simulator.vehicle.task.VehicleTask;
import com.logistics.simulator.vehicle.task.leavetask.LeaveTaskFactory;
import com.logistics.simulator.vehicle.task.leavetask.LeaveTaskFactoryImpl;
import com.logistics.simulator.vehicle.task.movetask.MoveVehicleTask;
import com.logistics.simulator.vehicle.task.movetask.MoveVehicleTaskFactory;
import com.logistics.simulator.vehicle.task.unloadingtask.UnloadingTaskFactory;
import com.logistics.simulator.vehicle.task.unloadingtask.UnloadingTaskFactoryImpl;

/**
 * @author Yifan
 *
 */
public class ScheduleCreatorImplTest {
	class MockupNetwork extends NetworkImpl {
		public MockupNetwork() {
			NodeImpl node1 = new NodeImpl(1, null);
			node1.setPosition(new Point3D(1, 0, 0));
			addNode(node1);
			NodeImpl node2 = new NodeImpl(2, null);
			node2.setPosition(new Point3D(2, 0, 0));
			addNode(node2);
			NodeImpl node3 = new NodeImpl(3, null);
			node3.setPosition(new Point3D(3, 0, 0));
			addNode(node3);
			NodeImpl node4 = new NodeImpl(4, null);
			node4.setPosition(new Point3D(4, 0, 0));
			addNode(node4);
			NodeImpl node5 = new NodeImpl(5, null);
			node5.setPosition(new Point3D(5, 0, 0));
			addNode(node5);
			addSegment(new SegmentImpl(null), 1, 2, false);
			addSegment(new SegmentImpl(null), 2, 3, true);
			addSegment(new SegmentImpl(null), 1, 4, false);
			addSegment(new SegmentImpl(null), 4, 3, true);
			addSegment(new SegmentImpl(null), 2, 5, false);
			addSegment(new SegmentImpl(null), 4, 5, false);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.logistics.simulator.network.NetworkImpl#getNearestNode(com.logistics.shared.Point3D)
		 */
		@Override
		public Node getNearestNode(Point3D point) {
			return this.getNodeById(1);
		}
	}

	/**
	 * Test method for {@link com.logistics.simulator.vehicle.scheduler.ScheduleCreatorImpl#createSchedule(java.util.List)}.
	 */
	@Test
	public void testCreateSchedule() {
		Network network = new MockupNetwork();
		
		VehicleImpl vehicle = new VehicleImpl(1);
		vehicle.setLeaveNodeId(5);
		vehicle.setUnloadNodeId(3);
		vehicle.setPosition(new Point3D(0, 0, 0));
		vehicle.setSpeed(0.1);
		
		Path path = new PathImpl();
		path.addNode(0, network.getNodeById(1));
		path.addNode(0, network.getNodeById(2));
		path.addNode(0, network.getNodeById(3));
		path.addNode(0, network.getNodeById(4));
		path.addNode(0, network.getNodeById(5));
		
		// Create schedule
		ScheduleFactory scheduleFactory = new ScheduleImplFactory();
		MoveVehicleTaskFactory moveVehicleTaskFactory = 
				new MoveVehicleTaskFactory(null);
		LeaveTaskFactory leaveTaskFactory = new LeaveTaskFactoryImpl(null);
		UnloadingTaskFactory unloadingTaskFactory = 
				new UnloadingTaskFactoryImpl();
		ScheduleCreator scheduleCreator = 
				new ScheduleCreatorImpl(network, 
						scheduleFactory,
						moveVehicleTaskFactory, 
						unloadingTaskFactory, 
						leaveTaskFactory);
		Schedule schedule = scheduleCreator.createSchedule(vehicle, path, 
				LocalDateTime.of(2015, 12, 01, 12, 0, 0));
		
		// Assertions
		List<VehicleTask> tasks = schedule.getTasks();
		MoveVehicleTask task = (MoveVehicleTask) tasks.get(0);
		assertEquals(LocalDateTime.of(2015, 12, 1, 12, 0, 0), 
				task.getStartTime());
		assertEquals(LocalDateTime.of(2015, 12, 1, 12, 0, 10),
				task.getEndTime());
		assertEquals(network.getNodeById(1), task.getDestination());
		assertNull(task.getConnection());
		assertEquals(LocalDateTime.of(2015, 12, 1, 12, 0, 50), 
				schedule.getETA());

		
	}

}
