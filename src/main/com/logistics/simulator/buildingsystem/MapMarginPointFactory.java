/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;

/**
 * @author yifansun
 *
 */
public class MapMarginPointFactory {

	public MapMarginPoint produceMapMarginPoint(
			Point3D position, Point3D defaultDestination) {
		return new MapMarginPoint(position, defaultDestination);
	}
}
