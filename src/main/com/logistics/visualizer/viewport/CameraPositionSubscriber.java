/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.shared.Point3D;

/**
 * @author yifan
 *
 */
public interface CameraPositionSubscriber {
	/**
	 * Update the camera position
	 * @param position
	 */
	public void updateCameraPosition(Point3D position);
}
