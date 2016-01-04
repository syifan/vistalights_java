/**
 * Logistics server side
 */
package com.logistics.simulator;

import com.logistics.simulator.scheduler.Clock;

/**
 * @author yifansun
 *
 */
public class SystemClock implements Clock {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.Clock#getCurrentTime()
	 */
	@Override
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}

}
