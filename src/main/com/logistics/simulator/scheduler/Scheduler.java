/**
 * Logistics server side
 */
package com.logistics.simulator.scheduler;

import java.time.LocalDateTime;

/**
 * @author yifansun
 *
 */
public interface Scheduler {

	/**
	 * @return the timeElapsed
	 */
	public abstract double getVirtualTimeElapsed();
	
	/**
	 * @return the virtual time
	 */
	public abstract LocalDateTime getVirtualTime();

	/**
	 * @param virtualTime the virtualTime to set
	 */
	public abstract void setVirtualTime(LocalDateTime virtualTime);
	
	
	/**
	 * @param timeScale The time scale to set
	 */
	public abstract void setTimeScale(double timeScale);

	/**
	 * Tick
	 */
	public abstract void tick();

}