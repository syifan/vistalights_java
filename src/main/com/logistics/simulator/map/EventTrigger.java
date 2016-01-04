/**
 * Logistics server side
 */
package com.logistics.simulator.map;

/**
 * @author yifan
 *
 */
public interface EventTrigger {
	/**
	 * Checks if the event should be triggered
	 * @return
	 */
	public boolean doTrigger();
	
	/**
	 * Checks is the event is still valid. If the event will not be triggered
	 * any more, return true.
	 * @return
	 */
	public boolean isInvalid();
}
