/**
 * Logistics server side
 */
package com.logistics.simulator.map;

/**
 * @author yifan
 *
 */
public interface MapEvent {
	public EventTrigger getEventTrigger();
	public EventExecutor getEventExecutor();
}
