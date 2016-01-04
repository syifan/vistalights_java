/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.node.Node;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class NodeViewObject extends ViewObject {

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public NodeViewObject(Visualizer visualizer, ViewPort viewPort, 
			Node node) {
		super(visualizer, viewPort);
		this.node = node;
	}
	
	/**
	 * The node this view object represents
	 */
	protected Node node;
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObject#render()
	 */
	public void render() {
		PGraphics canvas = layer.getCanvas();
		Point3D position = node.getPosition();
		canvas.fill(255, 0, 0);
		canvas.noStroke();
		canvas.ellipseMode(PConstants.CENTER);
		canvas.ellipse((float)position.getX(), (float)position.getY(),
				500, 500);
	}

}
