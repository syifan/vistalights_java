/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PGraphics;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.segment.Segment;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class SegmentViewObject extends ViewObject {

	private Segment segment;

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public SegmentViewObject(Visualizer visualizer, ViewPort viewPort,
			Segment segment) {
		super(visualizer, viewPort);
		this.segment = segment;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObject#render()
	 */
	public void render() {
		PGraphics canvas = layer.getCanvas();
		Node src = segment.getSourceNode();
		Node dst = segment.getDestinationNode();
		Point3D srcPos = src.getPosition();
		Point3D dstPos = dst.getPosition();
		Point3D vector = dstPos.subtract(srcPos);
		double dist = vector.length();
		
		canvas.pushMatrix();
		canvas.translate((float)srcPos.getX(), (float)srcPos.getY(), 0);
		double angle = vector.angle(new Point3D(1, 0, 0));
		if (vector.getY() > 0) angle = -angle;
		canvas.rotateZ((float)(-1 * angle));
		canvas.fill(0);
		canvas.noStroke();
		if (segment.isBidirectional()){
			canvas.rect(0, -50,  (float)dist, 100);
		} else {
			canvas.rect(0, -20, (float)dist, 40);
		}
		canvas.popMatrix();
	}

}
