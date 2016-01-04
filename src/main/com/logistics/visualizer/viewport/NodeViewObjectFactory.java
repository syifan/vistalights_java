/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.network.node.Node;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class NodeViewObjectFactory extends ViewObjectFactory {

	private Node node;

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public NodeViewObjectFactory(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, viewPort);
		// TODO Auto-generated constructor stub
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewObjectFactory#produceViewObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		return new NodeViewObject(visualizer, viewPort, node);
	}

}
