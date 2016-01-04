/**
 * Logistics server side
 */
package com.logistics.simulator.network.pathfinder;

import java.util.List;
import java.util.Set;

import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.scheduler.path.Path;

/**
 * @author Yifan
 *
 */
public interface PathFinder {
	public Set<Path> findPath(int sourceNodeId, int destinationNodeId);
}
