/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;


/**
 * @author Yifan
 *
 */
public interface ConflictResolver {

	/**
	 * 
	 */
	public void resolve(Schedule schedule);

}
