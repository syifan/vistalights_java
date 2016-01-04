/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface IntersectionFactory {
	public Intersection produceIntersection(Point3D position);
}
