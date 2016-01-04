/**
 * Logistics server side
 */
package com.logistics.simulator.network.loader;

import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.intersection.IntersectionCreator;
import com.logistics.simulator.network.intersection.IntersectionCreatorImpl;
import com.logistics.simulator.network.intersection.IntersectionFactory;
import com.logistics.simulator.network.intersection.IntersectionImplFactory;
import com.logistics.simulator.network.node.NodeCreator;
import com.logistics.simulator.network.node.NodeCreatorImpl;
import com.logistics.simulator.network.node.NodeFactory;
import com.logistics.simulator.network.node.NodeImplFactory;
import com.logistics.simulator.network.segment.SegmentCreator;
import com.logistics.simulator.network.segment.SegmentCreatorImpl;
import com.logistics.simulator.network.segment.SegmentFactory;
import com.logistics.simulator.network.segment.SegmentImplFactory;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.viewport.IntersectionViewObjectFactory;
import com.logistics.visualizer.viewport.NodeViewObjectFactory;
import com.logistics.visualizer.viewport.SegmentViewObjectFactory;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifan
 *
 */
public class NetworkLoaderImplFactory implements NetworkLoaderFactory {

	private Visualizer visualizer;
	private ViewPort viewport;
	private Network network;

	/**
	 * @param visualizer
	 * @param viewport
	 * @param network
	 */
	public NetworkLoaderImplFactory(Visualizer visualizer, 
			ViewPort viewport, Network network) {
		super();
		this.visualizer = visualizer;
		this.viewport = viewport;
		this.network = network;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.NetworkLoaderFactory#produceNetworkLoaderFactory()
	 */
	@Override
	public NetworkLoader produceNetworkLoaderFactory() {
		NodeFactory nodeFactory = new NodeImplFactory();
		NodeViewObjectFactory nodeViewObjectFactory = 
				new NodeViewObjectFactory(visualizer, viewport);
		NodeCreator nodeCreator = new NodeCreatorImpl(network, 
				viewport, nodeFactory, nodeViewObjectFactory);
		
		SegmentFactory segmentFactory = new SegmentImplFactory();
		SegmentViewObjectFactory segmentViewObjectFactory = 
				new SegmentViewObjectFactory(visualizer, viewport);
		SegmentCreator segmentCreator = new SegmentCreatorImpl(network, 
				viewport, segmentFactory, segmentViewObjectFactory);
		
		IntersectionFactory intersectionFactory = new IntersectionImplFactory();
		IntersectionViewObjectFactory intersectionViewObjectFactory = 
				new IntersectionViewObjectFactory(visualizer, viewport);
		IntersectionCreator intersectionCreator = new IntersectionCreatorImpl(
				network, viewport, intersectionFactory, 
				intersectionViewObjectFactory);
		
		NetworkLoader networkLoader = new NetworkLoaderImpl(nodeCreator, 
				intersectionCreator, segmentCreator);
		
		return networkLoader;
	}

}
