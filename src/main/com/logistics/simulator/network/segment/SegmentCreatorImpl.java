/**
 * Logistics server side
 */
package com.logistics.simulator.network.segment;

import com.logistics.simulator.network.Network;
import com.logistics.visualizer.viewport.SegmentViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifan
 *
 */
public class SegmentCreatorImpl implements SegmentCreator {
	
	protected Network network;
	protected ViewPort viewPort;
	protected SegmentFactory segmentFactory;
	protected SegmentViewObjectFactory segmentViewObjectFactory;

	/**
	 * @param network
	 * @param viewPort
	 * @param segmentFactory
	 * @param segmentViewObjectFactory
	 */
	public SegmentCreatorImpl(Network network, ViewPort viewPort, SegmentFactory segmentFactory,
			SegmentViewObjectFactory segmentViewObjectFactory) {
		super();
		this.network = network;
		this.viewPort = viewPort;
		this.segmentFactory = segmentFactory;
		this.segmentViewObjectFactory = segmentViewObjectFactory;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.SegmentCreator#createSegment(com.logistics.simulator.network.Node, com.logistics.simulator.network.Node, boolean)
	 */
	@Override
	public void createSegment(int sourceId, int destinationId, 
			boolean bidirectional) {
		// Create segment
		Segment segment = segmentFactory.produceSegment();
		segment.setBidirectional(bidirectional);
		
		// Add the segment to the network
		network.addSegment(segment, sourceId, destinationId, bidirectional);

		// Create view object
		segmentViewObjectFactory.setSegment(segment);
		ViewObject segmentViewObject = 
				segmentViewObjectFactory.produceViewObject();
		viewPort.addViewObject(segmentViewObject);
	}

}
