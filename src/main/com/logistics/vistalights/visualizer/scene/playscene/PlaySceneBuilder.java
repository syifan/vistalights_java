/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.apisystem.AddVehicleNotifier;
import com.logistics.apisystem.ApiManager;
import com.logistics.gamelogic.GameLogicController;
import com.logistics.gamelogic.GameLogicControllerFactory;
import com.logistics.simulator.Simulator;
import com.logistics.simulator.SimulatorImplFactory;
import com.logistics.simulator.SystemClock;
import com.logistics.simulator.scheduler.Clock;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.scheduler.SchedulerImpl;
import com.logistics.simulator.vehicle.VehicleJsonSerializer;
import com.logistics.simulator.vehicle.VehicleSerializer;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.viewport.VehicleViewObjectFactory;
import com.logistics.visualizer.viewport.VehicleViewObjectProducer;
import com.logistics.visualizer.viewport.VehicleViewObjectProducerImpl;
import com.logistics.visualizer.viewport.ViewPort;
import com.logistics.visualizer.viewport.ViewPortFactory;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;
import com.logistics.visualizerbasic.SceneKeyEventHandler;
import com.logistics.visualizerbasic.SceneMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;
import com.logistics.visualizerbasic.gui.GuiLayerKeyEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayerMouseEventHandler;

/**
 * @author yifansun
 *
 */
public class PlaySceneBuilder extends SceneBuilder {

	/**
	 * Visualizer
	 */
	private Visualizer visualizer;
	
	/**
	 * API Manager
	 */
	private ApiManager apiManager;

	/**
	 * @param visualizer
	 */
	public PlaySceneBuilder(Visualizer visualizer, ApiManager apiManager) {
		super();
		this.visualizer = visualizer;
		this.apiManager = apiManager;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.SceneBuilder#BuildScene()
	 */
	@Override
	public Scene buildScene() {
		// Create scheduler
		Clock clock = new SystemClock();
		Scheduler scheduler = new SchedulerImpl(clock);
		
		// View port
		ViewPortFactory viewPortFactory = new ViewPortFactory(visualizer);
		ViewPort viewPort = viewPortFactory.procudeViewPort();
		
		// Initialize simulator
		SimulatorImplFactory simulatorFactory = new SimulatorImplFactory(
				visualizer, viewPort);
		Simulator simulator = simulatorFactory.produceSimulator();
		
		// Create Vehicle Producer
		VehicleViewObjectFactory vehicleViewObjectFactory = 
				new VehicleViewObjectFactory(visualizer, viewPort, 
						viewPort.getCamera(), null);
		VehicleViewObjectProducer vehicleProducer = 
				new VehicleViewObjectProducerImpl(viewPort, 
						vehicleViewObjectFactory);
		simulator.addAddVehicleSubscriber(vehicleProducer);
		
		// Initialize game logic controller
		GameLogicControllerFactory gameLogicControllerFactory = 
				new GameLogicControllerFactory(simulator, scheduler, 
						apiManager, viewPort, visualizer);
		GameLogicController gameLogicController = 
				gameLogicControllerFactory.produceGameLogicController();
		
		// Gui layer
		GuiLayer gui = new GuiLayer(visualizer);
		GuiLayerMouseEventHandler guiLayerMouseEventHandler = 
				new GuiLayerMouseEventHandler(gui);
		gui.setMouseEventHandler(guiLayerMouseEventHandler);
		GuiLayerKeyEventHandler guiLayerKeyEventHandler = 
				new GuiLayerKeyEventHandler(gui);
		gui.setKeyEventHandler(guiLayerKeyEventHandler);
		
		// Create scene
		PlayScene playScene = new PlayScene(visualizer);
		playScene.addLayer(viewPort);
		playScene.addLayer(gui);
		
		// Scene click event handler
		SceneMouseEventHandler sceneMouseEventHandler = new
				SceneMouseEventHandler(playScene);
		playScene.setMouseEventHandler(sceneMouseEventHandler);
		SceneKeyEventHandler sceneKeyEventHandler = 
				new SceneKeyEventHandler(playScene);
		playScene.setKeyEventHandler(sceneKeyEventHandler);
		
		// Create status bar
		TimeLabelFactory timeLabelFactory = new TimeLabelFactory(visualizer, 
				gui, null, scheduler);
		SpeedControllerFactory speedControllerFactory = 
				new SpeedControllerFactory(visualizer, gui, null, scheduler);
		BudgetScoreMonitorFactory budgetScoreMonitorFactory = 
				new BudgetScoreMonitorFactory(visualizer, gui, null, 
						gameLogicController.getEconomicScoreManager());
		StatusBarBuilder statusBarBuilder = 
				new StatusBarBuilder(visualizer, gui, gui, timeLabelFactory,
						speedControllerFactory, budgetScoreMonitorFactory);
		StatusBar statusBar = statusBarBuilder.buildStatusBar();
		gui.addSubGuiElement(statusBar);
		
		// Create add vehicle notifier
		VehicleSerializer serializer = new VehicleJsonSerializer();
		AddVehicleNotifier addVehicleNotifier = 
				new AddVehicleNotifier(apiManager, serializer);
		simulator.addAddVehicleSubscriber(addVehicleNotifier);
		
		
		new Thread(gameLogicController).start();
		
		return playScene;
	}

}
