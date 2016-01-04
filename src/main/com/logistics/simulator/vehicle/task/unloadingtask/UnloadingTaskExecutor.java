/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.task.unloadingtask;

import com.logistics.simulator.vehicle.cargo.CargoScoreCounter;
import com.logistics.simulator.vehicle.task.VehicleTaskExecutor;

/**
 * @author Yifan
 *
 */
public class UnloadingTaskExecutor implements VehicleTaskExecutor {
	private CargoScoreCounter cargoScoreCounter;

	/**
	 * @param cargoScoreCounter
	 */
	public UnloadingTaskExecutor(CargoScoreCounter cargoScoreCounter) {
		super();
		this.cargoScoreCounter = cargoScoreCounter;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#initialize()
	 */
	@Override
	public void initialize() {
		// Nothing
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#isInitiated()
	 */
	@Override
	public boolean isInitiated() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleTaskExecutor#execute()
	 */
	@Override
	public void execute() {
		cargoScoreCounter.unload();
	}

}
