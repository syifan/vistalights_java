/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.network.intersection.Intersection;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class IntersectionViewObjectFactory extends ViewObjectFactory {

	private Intersection intersection;

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public IntersectionViewObjectFactory(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, viewPort);
		// TODO Auto-generated constructor stub
	}
	
	public void setIntersection(Intersection intersection) {
		this.intersection = intersection;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObjectFactory#produceViewObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		return new IntersectionViewObject(visualizer, viewPort, intersection);
	}

}
