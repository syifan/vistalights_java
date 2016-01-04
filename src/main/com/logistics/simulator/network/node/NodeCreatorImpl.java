/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.Network;
import com.logistics.visualizer.viewport.NodeViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author yifan
 *
 */
public class NodeCreatorImpl implements NodeCreator {
	
	protected Network network;
	protected ViewPort viewPort;
	protected NodeFactory nodeFactory;
	protected NodeViewObjectFactory nodeViewObjectFactory;
	

	/**
	 * @param network
	 * @param viewPort
	 * @param nodeFactory
	 * @param nodeViewObjectFactory
	 */
	public NodeCreatorImpl(Network network, ViewPort viewPort, NodeFactory nodeFactory,
			NodeViewObjectFactory nodeViewObjectFactory) {
		super();
		this.network = network;
		this.viewPort = viewPort;
		this.nodeFactory = nodeFactory;
		this.nodeViewObjectFactory = nodeViewObjectFactory;
	}


	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.NodeCreator#createNode(com.logistics.shared.Point3D)
	 */
	@Override
	public void createNode(int id, Point3D position) {
		Node node = nodeFactory.produceNode(id, position);
		nodeViewObjectFactory.setNode(node);
		network.addNode(node);
		ViewObject viewObject = nodeViewObjectFactory.produceViewObject();
		viewPort.addViewObject(viewObject);
	}

}
