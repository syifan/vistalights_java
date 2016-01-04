/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface NodeFactory {
	public Node produceNode(int id, Point3D position);
}
