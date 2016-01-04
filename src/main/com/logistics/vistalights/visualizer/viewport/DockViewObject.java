/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import com.logistics.shared.Point3D;
import com.logistics.simulator.buildingsystem.Dock;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class DockViewObject extends ViewObject {

	protected Dock dock;
	
	protected ImageRenderer symbolRenderer;
	
	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public DockViewObject(Visualizer visualizer, ViewPort viewPort, Dock dock) {
		super(visualizer, viewPort);
		this.dock = dock;
		this.scale = new Point3D(1500, 1500, 0);
		PImage symbol = null;
		switch(dock.getIndustry()) {
		case PETRO:
			symbol = visualizer.loadImage("assets/industry_symbol/petro.png");
			break;
		case BREAKBULK:
			symbol = visualizer.loadImage("assets/industry_symbol/breakbulk.png");
			break;
		case BULK:
			symbol = visualizer.loadImage("assets/industry_symbol/bulk.png");
			break;
		}
		if (symbol != null) {
			symbolRenderer = new ImageRenderer(symbol, layer);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.ViewObject#render()
	 */
	public void render() {
		/*
		PGraphics canvas = layer.getCanvas();
		canvas.noStroke();
		canvas.fill(255, 0, 0);
		canvas.ellipseMode(PConstants.CENTER);
		float x = (float) dock.getPosition().getX();
		float y = (float) dock.getPosition().getY();
		canvas.ellipse(x, y, 1500, 1500);
		if (symbolRenderer != null) {
			symbolRenderer.render(x, y, 1, 1500, 1500);
		}
		*/
	}
}
