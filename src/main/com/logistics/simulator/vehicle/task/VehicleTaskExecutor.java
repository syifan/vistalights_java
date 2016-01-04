/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task;

/**
 * @author Yifan
 *
 */
public interface VehicleTaskExecutor {
	/**
	 * Start the task. Do some init work to do this.
	 */
	public void initialize();
	
	/**
	 * Check if the task executor is initialized
	 * @return
	 */
	public boolean isInitiated();
	
	/**
	 * Execute the task
	 */
	public void execute();
}
