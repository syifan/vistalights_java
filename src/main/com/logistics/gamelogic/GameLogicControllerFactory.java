/**
 * Logistics server side
 */
package com.logistics.gamelogic;

import com.logistics.apisystem.ApiManager;
import com.logistics.simulator.ScoreManager;
import com.logistics.simulator.Simulator;
import com.logistics.simulator.SimulatorController;
import com.logistics.simulator.SimulatorControllerImpl;
import com.logistics.simulator.buildingsystem.DockCreator;
import com.logistics.simulator.buildingsystem.DockFactory;
import com.logistics.simulator.buildingsystem.MapMarginPointCreator;
import com.logistics.simulator.buildingsystem.MapMarginPointFactory;
import com.logistics.simulator.map.Map;
import com.logistics.simulator.map.MapEventLoader;
import com.logistics.simulator.map.MapEventLoaderFactory;
import com.logistics.simulator.map.MapEventLoaderImplFactory;
import com.logistics.simulator.map.MapEventRunner;
import com.logistics.simulator.map.MapEventRunnerImpl;
import com.logistics.simulator.map.MapLoader;
import com.logistics.simulator.map.VehicleCreator;
import com.logistics.simulator.map.VehicleCreatorImpl;
import com.logistics.simulator.network.loader.NetworkLoader;
import com.logistics.simulator.network.loader.NetworkLoaderFactory;
import com.logistics.simulator.network.loader.NetworkLoaderImplFactory;
import com.logistics.simulator.network.scheduler.NetworkShipScheduler;
import com.logistics.simulator.network.scheduler.NetworkShipSchedulerFactory;
import com.logistics.simulator.network.scheduler.NetworkShipSchedulerImplFactory;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.VehicleImplFactory;
import com.logistics.simulator.vehicle.VehicleRemover;
import com.logistics.simulator.vehicle.VehicleRemoverImpl;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.viewport.DockViewObjectFactory;
import com.logistics.visualizer.viewport.MapMarginPointViewObjectFactory;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifan
 *
 */
public class GameLogicControllerFactory {

	private Simulator simulator;
	private Scheduler scheduler;
	private ApiManager apiManager;
	private ViewPort viewPort;
	private Visualizer visualizer;

	/**
	 * Contructor
	 * @param simulator
	 * @param scheduler
	 * @param apiManager
	 * @param viewPort
	 * @param visualizer
	 */
	public GameLogicControllerFactory(Simulator simulator, 
			Scheduler scheduler,
			ApiManager apiManager, ViewPort viewPort, Visualizer visualizer) {
		super();
		this.simulator = simulator;
		this.scheduler = scheduler;
		this.apiManager = apiManager;
		this.viewPort = viewPort;
		this.visualizer = visualizer;
	}

	/**
	 * Produce the game logic controller
	 */
	public GameLogicController produceGameLogicController() {
		// Create a simulator controller
		SimulatorController simulatorController = 
				new SimulatorControllerImpl(simulator);
		
		// Create GameLogicController
		GameLogicController gameLogicController = new GameLogicController(
				simulatorController, scheduler, apiManager, viewPort);
		
		// Create a economic score manager
		ScoreManager economicScoreManager = new ScoreManager("ECONOMIC");
		gameLogicController.setEconomicScoreManager(economicScoreManager);
		
		// Load map
		Map map = new Map();
		DockFactory dockFactory = new DockFactory();
		DockViewObjectFactory dockViewObjectFactory = 
				new DockViewObjectFactory(visualizer, viewPort);
		DockCreator dockCreator = new DockCreator(viewPort, dockFactory, 
				dockViewObjectFactory, map);
		MapMarginPointFactory mapMarginPointFactory = 
				new MapMarginPointFactory();
		MapMarginPointViewObjectFactory mapMarginPointViewPortFactory = 
				new MapMarginPointViewObjectFactory(visualizer, viewPort);
		MapMarginPointCreator mapMarginPointCreator = 
				new MapMarginPointCreator(viewPort, mapMarginPointFactory, 
						mapMarginPointViewPortFactory, map);
		NetworkLoaderFactory networkLoaderFactory = 
				new NetworkLoaderImplFactory(visualizer, viewPort, 
						map.getNetwork());
		NetworkLoader networkLoader = 
				networkLoaderFactory.produceNetworkLoaderFactory();
		
		// Network ship scheduler
		VehicleRemover vehicleRemover = new VehicleRemoverImpl(
				simulator, viewPort);
		NetworkShipSchedulerFactory networkShipSchedulerFactory = 
				new NetworkShipSchedulerImplFactory(simulator, scheduler, 
						map.getNetwork(), vehicleRemover);
		NetworkShipScheduler networkShipScheduler = 
				networkShipSchedulerFactory.produceNetworkShipScheduler();
		
		// Event Loader
		VehicleCreator vehicleCreator = new VehicleCreatorImpl(
				new VehicleImplFactory(scheduler), 
				simulator, 
				simulatorController, 
				map.getNetwork(), 
				networkShipScheduler,
				scheduler, economicScoreManager);
		MapEventLoaderFactory mapEventLoaderFactory = 
				new MapEventLoaderImplFactory(map, scheduler, vehicleCreator);
		MapEventLoader mapEventLoader = 
				mapEventLoaderFactory.produceMapEventLoader();
		
		// Map Loader
		MapLoader mapLoader = new MapLoader(map, scheduler, dockCreator, 
				mapMarginPointCreator, networkLoader, mapEventLoader);
		try {
			mapLoader.loadMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		// Create map event runner
		MapEventRunner mapEventRunner = new MapEventRunnerImpl(map);
		gameLogicController.setMapEventRunner(mapEventRunner);
		
		return gameLogicController;	
	}
	
}
