/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.cargo;

import java.time.LocalDateTime;

import com.logistics.simulator.ScoreManager;
import com.logistics.simulator.scheduler.Scheduler;

/**
 * A CargoScoreCounter counts the effect of cargo system on economic score and
 * update the score
 * @author yifan
 *
 */
public class CargoScoreCounter {

	/**
	 * Dependency on the scheduler
	 */
	protected Scheduler scheduler;
	
	/**
	 * The cargo container that this cargo score counter is counting
	 */
	protected CargoContainer cargoContainer;
	
	/**
	 * The economic score manager that manages the score to update
	 */
	protected ScoreManager score;

	/**
	 * @param scheduler
	 * @param cargoContainer
	 * @param score
	 */
	public CargoScoreCounter(Scheduler scheduler, 
			CargoContainer cargoContainer, ScoreManager score) {
		super();
		this.scheduler = scheduler;
		this.cargoContainer = cargoContainer;
		this.score = score;
	}
	
	/**
	 * Count the effect of the cargo container in each simulator cycle
	 */
	public void tick() {
		double cargoTonnage = cargoContainer.tonnage;
		LocalDateTime dueTime = cargoContainer.dueTime;
		double cost = 0;
		if (dueTime.isAfter(scheduler.getVirtualTime())) {
			cost = cargoContainer.preDueCost;
		} else {
			cost = cargoContainer.postDueCost;
		}
		double finalCost = scheduler.getVirtualTimeElapsed() * cost * 
				cargoTonnage;
		score.addScore(-finalCost);
	}

	/**
	 * @return
	 */
	public void unload() {
		double timeElapsed = scheduler.getVirtualTimeElapsed();
		double tonnageToUnload = this.cargoContainer.unloadingSpeed * 
				timeElapsed;
		if (tonnageToUnload > cargoContainer.tonnage) {
			tonnageToUnload = cargoContainer.tonnage;
		}
		cargoContainer.tonnage -= tonnageToUnload;
		score.addScore(tonnageToUnload);
	}
}
