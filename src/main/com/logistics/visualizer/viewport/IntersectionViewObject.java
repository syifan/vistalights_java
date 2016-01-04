/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.util.Set;

import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.intersection.Intersection;
import com.logistics.simulator.network.node.Node;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class IntersectionViewObject extends ViewObject {

	private Intersection intersection;

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public IntersectionViewObject(Visualizer visualizer, ViewPort viewPort,
			Intersection intersection) {
		super(visualizer, viewPort);
		this.intersection = intersection;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObject#render()
	 */
	public void render() {
		PGraphics canvas = layer.getCanvas();
		Set<Node> destinations = intersection.getDestinations();
		synchronized(destinations) {
			for (Node node: destinations) {
				Point3D centerPos = intersection.getPosition();
				Point3D nodePos = node.getPosition();
				Point3D vector = nodePos.subtract(centerPos);
				double dist = vector.length();
				canvas.pushMatrix();
				canvas.translate((float)centerPos.getX(), 
						(float)centerPos.getY(), 0);
				double angle = vector.angle(new Point3D(1, 0, 0));
				if (vector.getY() > 0) angle = -angle;
				canvas.rotateZ((float)(-1 * angle));
				canvas.fill(0, 255, 0);
				canvas.noStroke();
				canvas.rect(0, -10,  (float)dist, 20);
				canvas.popMatrix();
			}
		}
	}

}
