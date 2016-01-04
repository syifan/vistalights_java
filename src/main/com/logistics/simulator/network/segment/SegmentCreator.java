/**
 * Logistics server side
 */
package com.logistics.simulator.network.segment;

/**
 * @author yifan
 *
 */
public interface SegmentCreator {
	public void createSegment(int sourceId, int destinationId, 
			boolean bidirectional);
}
