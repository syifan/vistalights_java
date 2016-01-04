/**
 * Logistics server side
 */
package com.logistics.gamelogic;

import java.time.LocalDateTime;

import com.logistics.apisystem.ApiManager;
import com.logistics.simulator.ScoreManager;
import com.logistics.simulator.SimulatorController;
import com.logistics.simulator.map.MapEventRunner;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifansun
 *
 */
public class GameLogicController implements Runnable {
	
	/**
	 * Simulator
	 */
	protected SimulatorController simulatorController;
	
	/**
	 * Scheduler
	 */
	protected Scheduler scheduler;
	
	/**
	 * API manager
	 */
	protected ApiManager apiManager;
	
	/**
	 * View port
	 */
	protected ViewPort viewPort;
	
	/**
	 * Map event runner
	 */
	protected MapEventRunner mapEventRunner;
	
	/**
	 * @param mapEventRunner the mapEventRunner to set
	 */
	public void setMapEventRunner(MapEventRunner mapEventRunner) {
		this.mapEventRunner = mapEventRunner;
	}

	/**
	 * 
	 */
	protected ScoreManager economicScoreManager;

	/**
	 * @return the economicScoreManager
	 */
	public ScoreManager getEconomicScoreManager() {
		return economicScoreManager;
	}

	/**
	 * @param economicScoreManager the economicScoreManager to set
	 */
	public void setEconomicScoreManager(ScoreManager economicScoreManager) {
		this.economicScoreManager = economicScoreManager;
	}

	/**
	 * Game end time
	 */
	protected LocalDateTime endTime;
	
	/**
	 * Constructor
	 */
	public GameLogicController(SimulatorController simulatorController, 
			Scheduler scheduler, 
			ApiManager apiManager, ViewPort viewPort) {
		// Dependency injection
		this.simulatorController = simulatorController;
		this.scheduler = scheduler;
		this.apiManager = apiManager;
		this.viewPort = viewPort;
		
		// Set game end time
		endTime = scheduler.getVirtualTime().plusDays(50);
	}

	/**
	 * @return
	 */
	public boolean checkGameStop() {
		LocalDateTime currentTime = scheduler.getVirtualTime();
		if (currentTime.compareTo(endTime) >= 0) {
			//apiManager.stopGame();
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			scheduler.tick();
			mapEventRunner.tick();
			simulatorController.tick();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
