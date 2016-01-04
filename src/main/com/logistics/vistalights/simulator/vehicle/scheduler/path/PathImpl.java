/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler.path;

import java.util.ArrayList;
import java.util.List;

import com.logistics.simulator.network.node.Node;

public class PathImpl implements Path {
	private List<Node> nodes = new ArrayList<Node>();
	
	public PathImpl() {}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#addNode(com.logistics.simulator.network.node.Node)
	 */
	@Override
	public void addNode(int index, Node node) {
		nodes.add(index, node);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#getNode(int)
	 */
	@Override
	public Node getNode(int index) {
		return nodes.get(index);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#removeNode(int)
	 */
	@Override
	public void removeNode(int index) {
		nodes.remove(index);
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#size()
	 */
	@Override
	public int size() {
		return nodes.size();
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#joinPath(com.logistics.simulator.vehicle.scheduler.path.Path)
	 */
	@Override
	public Path joinPath(Path path) {
		Path new_path = new PathImpl();
		
		for (Node node : nodes) {
			new_path.addNode(node);
		}
		
		for (int i = 0; i < path.size(); i++) {
			new_path.addNode(path.getNode(i));
		}
		
		return new_path;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.scheduler.path.Path#addNode(com.logistics.simulator.network.node.Node)
	 */
	@Override
	public void addNode(Node node) {
		this.nodes.add(node);
	};
	
	
}
