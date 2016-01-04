/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.simulator.buildingsystem.MapMarginPoint;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public class MapMarginPointViewObject extends ViewObject {

	protected MapMarginPoint mapMarginPoint;
	
	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public MapMarginPointViewObject(Visualizer visualizer, ViewPort viewPort, 
			MapMarginPoint mapMarginPoint) {
		super(visualizer, viewPort);
		this.mapMarginPoint = mapMarginPoint;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.ViewObject#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		canvas.noStroke();
		canvas.fill(0, 255, 0);
		canvas.ellipseMode(PConstants.CENTER);
		canvas.ellipse((float)mapMarginPoint.getPosition().getX(), 
				(float)mapMarginPoint.getPosition().getY(),
				1500, 1500);
	}

}
