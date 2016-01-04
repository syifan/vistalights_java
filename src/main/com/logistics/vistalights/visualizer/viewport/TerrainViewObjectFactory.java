/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PImage;

import com.logistics.simulator.Terrain;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public class TerrainViewObjectFactory extends ViewObjectFactory {

	/** 
	 * The terrain object
	 */
	private Terrain terrain;

	/**
	 * @param visualizer
	 */
	public TerrainViewObjectFactory(Visualizer visualizer, ViewPort viewPort, 
			Terrain terrain) {
		super(visualizer, viewPort);
		this.terrain = terrain;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObjectFactory#produceVisualizerObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		TerrainViewObject terrainViewObject = new TerrainViewObject(
				visualizer, viewPort, terrain);
		
		// Load image
		PImage image = visualizer.loadImage("maps/map(0,0)/map(0,0)_min.png");
		terrainViewObject.setTerrainImage(image);
		
		return terrainViewObject;
	}

}
