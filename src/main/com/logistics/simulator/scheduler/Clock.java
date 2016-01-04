/**
 * Logistics server side
 */
package com.logistics.simulator.scheduler;

/**
 * An interface that provide to the scheduler to get current time
 * 
 * @author yifansun
 *
 */
public interface Clock {
	/**
	 * Get current time in millisecond
	 * @return
	 */
	public long getCurrentTime();
}
