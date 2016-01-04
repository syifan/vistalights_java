/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import java.util.Set;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface IntersectionCreator {
	public void createIntersection(Point3D position, 
			Set<Integer> connectedNodeId);
}
