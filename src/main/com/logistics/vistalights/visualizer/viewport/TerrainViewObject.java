/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PGraphics;
import processing.core.PImage;

import com.logistics.simulator.Terrain;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.VisualizerObject;

/**
 * @author yifansun
 *
 */
public class TerrainViewObject extends ViewObject {
	
	/**
	 * The terrain simulator object 
	 */
	private Terrain terrain;
	
	/**
	 * The image of the terrain
	 */
	private PImage terrainImage;
	
	/**
	 * The flat image render
	 */
	private ImageRenderer mapRenderer; 

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public TerrainViewObject(Visualizer visualizer, ViewPort viewPort, 
			Terrain terrain) {
		super(visualizer, viewPort);
		this.terrain = terrain;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		mapRenderer.render(50000, 50000, -100, 100000, 100000);
	}

	/**
	 * @param image
	 */
	public void setTerrainImage(PImage terrainImage) {
		this.terrainImage = terrainImage;
		
		// Init map render
		mapRenderer = new ImageRenderer(terrainImage, layer);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.VisualizerObject#isMouseIn()
	 */
	@Override
	protected boolean isMouseIn(MouseEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
