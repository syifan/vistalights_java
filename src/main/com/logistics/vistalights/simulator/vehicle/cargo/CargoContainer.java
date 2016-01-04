/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.cargo;

import java.time.LocalDateTime;

/**
 * A cargo container is a subsystem of an vehicle and manages things related 
 * to cargos
 * @author yifan
 *
 */
public class CargoContainer {
	
	protected LocalDateTime dueTime;
	
	protected double postDueCost = 3e-5;

	protected double preDueCost = 3e-10;

	protected double tonnage;

	protected double unloadingSpeed = 0.5;
	
	protected CargoScoreCounter cargoScoreCounter;

	/**
	 * @param tonnage
	 * @param dueTime
	 * @param preDueCost
	 * @param postDueCost
	 */
	public CargoContainer(double tonnage, 
			LocalDateTime dueTime) {
		super();
		this.tonnage = tonnage;
		this.dueTime = dueTime;
	}

	/**
	 * @return the dueTime
	 */
	public LocalDateTime getDueTime() {
		return dueTime;
	}

	/**
	 * @return the postDueCost
	 */
	public double getPostDueCost() {
		return postDueCost;
	}

	/**
	 * @return the preDueCost
	 */
	public double getPreDueCost() {
		return preDueCost;
	}

	/**
	 * @return the tonnage
	 */
	public double getTonnage() {
		return tonnage;
	}

	/**
	 * @return the unloadingSpeed
	 */
	public double getUnloadingSpeed() {
		return unloadingSpeed;
	}

	/**
	 * @param dueTime the dueTime to set
	 */
	public void setDueTime(LocalDateTime dueTime) {
		this.dueTime = dueTime;
	}
	
	/**
	 * @param postDueCost the postDueCost to set
	 */
	public void setPostDueCost(double postDueCost) {
		this.postDueCost = postDueCost;
	}
	
	/**
	 * @param preDueCost the preDueCost to set
	 */
	public void setPreDueCost(double preDueCost) {
		this.preDueCost = preDueCost;
	}
	
	/**
	 * @param tonnage the tonnage to set
	 */
	public void setTonnage(double tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * @param unloadingSpeed the unloadingSpeed to set
	 */
	public void setUnloadingSpeed(double unloadingSpeed) {
		this.unloadingSpeed = unloadingSpeed;
	}
	
	public void setCargoScoreCounter(CargoScoreCounter cargoScoreCounter) {
		this.cargoScoreCounter = cargoScoreCounter;
	}

	/**
	 * @return
	 */
	public CargoScoreCounter getCargoScoreCounter() {
		return cargoScoreCounter;
	}
	
}
