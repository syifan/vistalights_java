/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler.path;

import com.logistics.simulator.network.node.Node;

/**
 * A path is a list of node that the vehicle will move along
 */
public interface Path {
	void addNode(int index, Node node);
	void addNode(Node node);
	Node getNode(int index);
	void removeNode(int index);
	int size();
	Path joinPath(Path path);
}
