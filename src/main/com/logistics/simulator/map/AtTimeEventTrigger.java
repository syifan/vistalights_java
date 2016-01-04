/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.time.LocalDateTime;

import com.logistics.simulator.scheduler.Scheduler;

/**
 * @author yifan
 *
 */
public class AtTimeEventTrigger implements EventTrigger {
	
	
	private LocalDateTime time;

	private Scheduler scheduler;
	
	private boolean triggered = false;

	/**
	 * @param time
	 */
	public AtTimeEventTrigger(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.EventTrigger#doTrigger()
	 */
	@Override
	public boolean doTrigger() {
		if (scheduler.getVirtualTime().isEqual(time) || 
				scheduler.getVirtualTime().isAfter(time)) {
			triggered = true;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.EventTrigger#isInvalid()
	 */
	@Override
	public boolean isInvalid() {
		// TODO Auto-generated method stub
		return triggered;
	}

}
