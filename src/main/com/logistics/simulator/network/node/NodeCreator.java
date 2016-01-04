/**
 * Logistics server side
 */
package com.logistics.simulator.network.node;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface NodeCreator {
	public void createNode(int id, Point3D position);
}
