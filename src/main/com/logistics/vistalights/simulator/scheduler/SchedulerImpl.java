/**
 * Logistic server side
 */
package com.logistics.simulator.scheduler;

import java.time.LocalDateTime;

/**
 * A scheduler is a singleton that manage the global time
 * 
 * @author Yifan Sun
 *
 */
public class SchedulerImpl implements Scheduler {
	
	/**
	 * Clock object that gets current time
	 */
	Clock clock;
	
	/**
	 * Last tick time
	 */
	protected long lastTickRealTime;
	
	/**
	 * Current time 
	 */
	protected long currentRealTime;
	
	/**
	 * The time in the simulated world
	 */
	protected LocalDateTime virtualTime = LocalDateTime.of(2014, 11, 19, 12, 0);
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.Scheduler#getVirtualTime()
	 */
	public LocalDateTime getVirtualTime() {
		return virtualTime;
	}

	/**
	 * @param worldTime the worldTime to set
	 */
	public void setVirtualTime(LocalDateTime worldTime) {
		this.virtualTime = worldTime;
	}

	/**
	 * Time elapsed from last tick to current tick, in the simulated world
	 */
	protected double virtualTimeElapsed;
	
	/**
	 * Time elapsed from last tick to current tick, in the host space
	 */
	protected double realTimeElapsed;
	
	/**
	 * The end game time
	 */
	protected LocalDateTime endTime = LocalDateTime.of(2014,  12, 19, 12, 0);
	
	/**
	 * The speed scale of the simulator
	 */
	protected double timeScale = 100;
	
	/**
	 * @return the timeScale
	 */
	public double getTimeScale() {
		return timeScale;
	}

	/**
	 * @param timeScale the timeScale to set
	 */
	public void setTimeScale(double timeScale) {
		this.timeScale = timeScale;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.Scheduler#getVirtualTimeElapsed()
	 */
	@Override
	public double getVirtualTimeElapsed() {
		return virtualTimeElapsed;
	}

	/**
	 * Private instructor
	 * @param clock 
	 */
	public SchedulerImpl(Clock clock){
		this.clock = clock;
		lastTickRealTime = clock.getCurrentTime();
	};

	/**
	 * Update its time
	 */
	public void tick() {
		currentRealTime = clock.getCurrentTime();
		realTimeElapsed = (double)(currentRealTime - lastTickRealTime) / (double)1e3;
		
		// Limit the simulation accuracy
		virtualTimeElapsed = realTimeElapsed * timeScale;
		if (virtualTimeElapsed > 1000) {
			virtualTimeElapsed = 1000;
		}
		
		// Update world time
		this.virtualTime = this.virtualTime.plusNanos(
				Math.round(virtualTimeElapsed * 1e9));
		
		// Update time to clients
		lastTickRealTime = currentRealTime;
	}
	
	
}
