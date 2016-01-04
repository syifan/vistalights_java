/**
 * Logistics server side
 */
package com.logistics.simulator.oilspilling;

import com.logistics.shared.Point3D;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.scheduler.SchedulerImpl;

/**
 * @author yifan
 *
 */
public class OilLeakSource {

	/**
	 * Total amount of oil that this lead contains
	 */
	protected double totalAmount = 10000;
	
	/**
	 * Amount to be leaked per second
	 */
	protected double leakageRate = 2;
	
	/**
	 * Position of the leakage
	 */
	protected Point3D position;
	
	/**
	 * the oil area this source is leaking to 
	 */
	OilArea oilArea = null;
	
	/**
	 * The scheduler
	 */
	Scheduler scheduler = null;

	/**
	 * @param position
	 */
	public OilLeakSource(Scheduler scheduler, OilArea oilArea, Point3D position) {
		super();
		this.scheduler = scheduler;
		this.oilArea = oilArea;
		this.position = position;
		oilArea.startToLeak(this);
	}
	
	/**
	 * Leak oil to oil area
	 * @return 
	 */
	public void Leak(double timeElapsed) {
		if (totalAmount <= 0) return;
		
		// Get the amount to lead
		double amountToLeak = leakageRate * timeElapsed;
		
		// Inject to oil are
		oilArea.inject(position, amountToLeak);
		
		// Reduce total amount
		this.totalAmount -= amountToLeak;
		
	}

	/**
	 * @return
	 */
	public Point3D getPosition() {
		return this.position;
	}
	

}
