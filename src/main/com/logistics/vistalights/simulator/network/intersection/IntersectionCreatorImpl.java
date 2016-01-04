/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.Network;
import com.logistics.visualizer.viewport.IntersectionViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifan
 *
 */
public class IntersectionCreatorImpl implements IntersectionCreator {
	
	protected Network network;
	protected ViewPort viewPort;
	protected IntersectionFactory intersectionFactory;
	protected IntersectionViewObjectFactory intersectionViewObjectFactory;

	/**
	 * @param network
	 * @param viewPort
	 * @param nodeFactory
	 * @param nodeViewObjectFactory
	 */
	public IntersectionCreatorImpl(Network network, ViewPort viewPort, 
			IntersectionFactory intersectionFactory,
			IntersectionViewObjectFactory intersectionViewObjectFactory) {
		super();
		this.network = network;
		this.viewPort = viewPort;
		this.intersectionFactory = intersectionFactory;
		this.intersectionViewObjectFactory = intersectionViewObjectFactory;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.IntersectionCreator#createIntersection(com.logistics.shared.Point3D, java.util.Set)
	 */
	@Override
	public void createIntersection(Point3D position, 
			Set<Integer> connectedNodeId) {
		// Create intersection
		Intersection intersection = 
				intersectionFactory.produceIntersection(position);
		
		// Add the intersection to network
		network.addIntersection(intersection, connectedNodeId);
		
		// Create intersection view object
		intersectionViewObjectFactory.setIntersection(intersection);
		ViewObject viewObject = 
				intersectionViewObjectFactory.produceViewObject();
		viewPort.addViewObject(viewObject);
	}

}
