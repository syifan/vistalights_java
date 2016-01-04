/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;

import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class ConflictResolverImplTest {

	class MockupVehicleTask implements VehicleTask {
		LocalDateTime startTime, endTime;
		TaskReserver reserver;

		/**
		 * @param startTime
		 * @param endTime
		 */
		public MockupVehicleTask(LocalDateTime startTime, LocalDateTime endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			reserver = new MockupTaskReserver(this);
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleTask#getStartTime()
		 */
		@Override
		public LocalDateTime getStartTime() {
			return startTime;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleTask#getEndTime()
		 */
		@Override
		public LocalDateTime getEndTime() {
			return endTime;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleTask#postpone(java.time.Duration)
		 */
		@Override
		public void postpone(Duration amount) {
			startTime = startTime.plus(amount);
			endTime = endTime.plus(amount);
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskExecutor()
		 */
		@Override
		public VehicleTaskExecutor getTaskExecutor() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleTask#getTaskReserver()
		 */
		@Override
		public TaskReserver getTaskReserver() {
			// TODO Auto-generated method stub
			return reserver;
		}
		
	}
	
	static class MockupTaskReserver implements TaskReserver {
		
		static int involkTime = 0;
		VehicleTask task;

		/**
		 * @param task
		 */
		public MockupTaskReserver(VehicleTask task) {
			super();
			this.task = task;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.TaskReserver#hasConflict()
		 */
		@Override
		public boolean hasConflict() {
			if (involkTime == 2 || involkTime == 3) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.TaskReserver#nextNoConflictTime()
		 */
		@Override
		public LocalDateTime nextNoConflictTime() {
			involkTime++;
			if (involkTime == 2) {
				return LocalDateTime.of(2015, 1, 1, 12, 10, 0);
			} else if (involkTime == 3) {
				return LocalDateTime.of(2015, 1, 1, 12, 16, 0);
			}
			return task.getStartTime();
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.TaskReserver#makeReservation()
		 */
		@Override
		public void makeReservation() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * Test method for {@link com.logistics.simulator.vehicle.scheduler.ConflictResolverImpl#resolve(com.logistics.simulator.vehicle.scheduler.Schedule)}.
	 */
	@Test
	public void testResolve() {
		Schedule schedule = new ScheduleImpl();
		schedule.addTask(new MockupVehicleTask(
				LocalDateTime.of(2015, 1, 1, 12, 1, 0), 
				LocalDateTime.of(2015, 1, 1, 12, 3, 0)));
		schedule.addTask(new MockupVehicleTask(
				LocalDateTime.of(2015, 1, 1, 12, 3, 0), 
				LocalDateTime.of(2015, 1, 1, 12, 6, 0)));
		
		ConflictResolverImpl resolver = new ConflictResolverImpl();
		resolver.resolve(schedule);
		
		assertEquals(LocalDateTime.of(2015, 1, 1, 12, 16, 0), 
				schedule.getTasks().get(0).getStartTime());
		assertEquals(LocalDateTime.of(2015, 1, 1, 12, 18, 0), 
				schedule.getTasks().get(0).getEndTime());
		assertEquals(LocalDateTime.of(2015, 1, 1, 12, 18, 0), 
				schedule.getTasks().get(1).getStartTime());
		assertEquals(LocalDateTime.of(2015, 1, 1, 12, 21, 0), 
				schedule.getTasks().get(1).getEndTime());
	}

}
