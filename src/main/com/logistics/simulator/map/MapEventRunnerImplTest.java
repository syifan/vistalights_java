/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.logistics.simulator.vehicle.task.VehicleTask;

/**
 * @author Yifan
 *
 */
public class MapEventRunnerImplTest {
	
	class MockupTrigger implements EventTrigger {
		
		private boolean doTrigger;
		private boolean isInvalid;
		
		public MockupTrigger(boolean doTrigger, boolean isInvalid) {
			this.doTrigger = doTrigger;
			this.isInvalid = isInvalid;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.map.EventTrigger#doTrigger()
		 */
		@Override
		public boolean doTrigger() {
			return doTrigger;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.map.EventTrigger#isInvalid()
		 */
		@Override
		public boolean isInvalid() {
			return isInvalid;
		}
		
	}
	
	static class MockupExecutor implements EventExecutor {

		static public int times = 0;
		
		/* (non-Javadoc)
		 * @see com.logistics.simulator.map.EventExecutor#execute()
		 */
		@Override
		public void execute() {
			times++;
		}
		
	}
	
	class MockupMapEvent implements MapEvent {
		private EventTrigger trigger;
		private EventExecutor executor;
		
		public MockupMapEvent(EventTrigger trigger, EventExecutor executor) {
			this.trigger = trigger;
			this.executor = executor;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.map.MapEvent#getEventTrigger()
		 */
		@Override
		public EventTrigger getEventTrigger() {
			return trigger;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.map.MapEvent#getEventExecutor()
		 */
		@Override
		public EventExecutor getEventExecutor() {
			return executor;
		}
		
	}

	class MockupMap extends Map {
		private Set<MapEvent> mapEvents = new HashSet<MapEvent>();
		
		public MockupMap() {
			MockupMapEvent event = new MockupMapEvent(
					new MockupTrigger(true, false), 
					new MockupExecutor());
			mapEvents.add(event);
			event = new MockupMapEvent(
					new MockupTrigger(false, false),
					new MockupExecutor());
			mapEvents.add(event);
			event = new MockupMapEvent(
					new MockupTrigger(false, true),
					new MockupExecutor());
			mapEvents.add(event);
			event = new MockupMapEvent(
					new MockupTrigger(true, true),
					new MockupExecutor());
			mapEvents.add(event);
		}
		
		@Override
		public Set<MapEvent> getMapEvents() {
			return mapEvents;
		}
	}
	
	@Test
	public void testTick() {
		MockupMap map = new MockupMap();
		MapEventRunnerImpl mapEventRunner = new MapEventRunnerImpl(map);
		mapEventRunner.tick();
		assertEquals(2, MockupExecutor.times);
		assertEquals(2, map.getMapEvents().size());
	}

}
