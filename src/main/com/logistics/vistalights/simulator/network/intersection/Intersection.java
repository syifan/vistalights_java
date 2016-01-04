/**
 * Logistics server side
 */
package com.logistics.simulator.network.intersection;

import com.logistics.shared.Point3D;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;

/**
 * @author yifan
 *
 */
public interface Intersection extends RoadConnection{
	public Point3D getPosition();
	public void setPosition(Point3D position);
	public void addDestination(Node node);
}
