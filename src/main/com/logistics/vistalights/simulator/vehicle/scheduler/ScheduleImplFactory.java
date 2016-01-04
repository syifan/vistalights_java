/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;


/**
 * @author Yifan
 *
 */
public class ScheduleImplFactory implements ScheduleFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.ScheduleFactory#produceSchedule()
	 */
	@Override
	public Schedule produceSchedule() {
		return new ScheduleImpl();
	}

}
