/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.network.segment.Segment;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class SegmentViewObjectFactory extends ViewObjectFactory {

	private Segment segment;

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public SegmentViewObjectFactory(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, viewPort);
		// TODO Auto-generated constructor stub
	}
	
	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObjectFactory#produceViewObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		return new SegmentViewObject(visualizer, viewPort, segment);
	}

}
