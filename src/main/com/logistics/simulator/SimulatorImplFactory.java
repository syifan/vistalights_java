/**
 * Logistics server side
 */
package com.logistics.simulator;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.viewport.TerrainViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * Create the simulator 
 * @author yifansun
 *
 */
public class SimulatorImplFactory {

	/**
	 * The scheduler object
	 */
	private Visualizer visualizer;
	private ViewPort viewPort;

	/**
	 * @param scheduler
	 */
	public SimulatorImplFactory(Visualizer visualizer, ViewPort viewPort) {
		super();
		this.visualizer = visualizer;
		this.viewPort = viewPort;
	}

	/**
	 * Produce the simulator object
	 * @return
	 */
	public Simulator produceSimulator() {
		SimulatorImpl simulator = new SimulatorImpl();
		
		// Create the terrain
		TerrainFactory terrainFactory = new TerrainFactory();
		Terrain terrain = terrainFactory.produceTerrain();
		simulator.setTerrain(terrain);
		
		// Create the terrain object
		TerrainViewObjectFactory terrainViewObjectFactory = 
				new TerrainViewObjectFactory(visualizer, viewPort, 
						(Terrain) terrain);
		ViewObject terrainViewObject = terrainViewObjectFactory.
				produceViewObject();
		viewPort.addViewObject(terrainViewObject);
		
		return simulator;
	}
}
