/**
 * Logistics server side
 */
package com.logistics.simulator.network.pathfinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.vehicle.scheduler.path.Path;
import com.logistics.simulator.vehicle.scheduler.path.PathImpl;

/**
 * @author Yifan
 *
 */
public class BfsPathFinder implements PathFinder {

	protected Network network;
	
	protected class TreeNode {
		protected Node node;
		protected TreeNode parent;
		protected TreeNode(Node node, TreeNode parent) {
			this.node = node;
			this.parent = parent;
		};
	}

	/**
	 * @param network
	 */
	public BfsPathFinder(Network network) {
		super();
		this.network = network;
	}
	
	protected boolean isNodeAlreadyOnPath(TreeNode leaf, Node nextNode) {
		while (leaf != null) {
			if (leaf.node == nextNode) {
				return true;
			}
			leaf = leaf.parent;
		}
		return false;
	}
	
	protected Path getPath(TreeNode leaf) {
		Path path = new PathImpl();
		while (leaf != null) {
			path.addNode(0, leaf.node);
			leaf = leaf.parent;
		}
		return path;
	} 

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.PathFinder#findPath(int, int)
	 */
	@Override
	public Set<Path> findPath(int sourceNodeId, int destinationNodeId) {
		Node srcNode = network.getNodeById(sourceNodeId);
		Node dstNode = network.getNodeById(destinationNodeId);
		Set<Path> paths = new HashSet<Path>();
		
		List<TreeNode> expandQueue = new ArrayList<TreeNode>();
		
		TreeNode root = new TreeNode(srcNode, null);
		expandQueue.add(root);
		while(!expandQueue.isEmpty()) {
			// Get a node to expand
			TreeNode parent = expandQueue.get(0);
			expandQueue.remove(0);
			
			// Expand tree
			Node parentNode = parent.node;
			for(RoadConnection connection : parentNode.getConnections()) {
				for (Node nextNode : connection.getDestinations()) {
					// Check if nextNode is already in the path
					if (isNodeAlreadyOnPath(parent, nextNode)) {
						continue;
					}
					
					// Create child
					TreeNode child = new TreeNode(nextNode, parent);
					
					// Check if nextNode is destination
					if (nextNode == dstNode) {
						paths.add(getPath(child));
						continue;
					} else {
						// Not destination, to be expanded
						expandQueue.add(child);
					}
				}
			}
		}
		
		return paths;
	}

}
