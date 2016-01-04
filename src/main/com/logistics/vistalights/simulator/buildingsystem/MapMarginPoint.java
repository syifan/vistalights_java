/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;

/**
 * @author yifansun
 *
 */
public class MapMarginPoint extends Building {

	protected Point3D defaultDestination;

	/**
	 * @return the defaultDestination
	 */
	public Point3D getDefaultDestination() {
		return defaultDestination;
	}

	/**
	 * @param defaultDestination the defaultDestination to set
	 */
	public void setDefaultDestination(Point3D defaultDestination) {
		this.defaultDestination = defaultDestination;
	}

	/**
	 * @param position
	 */
	public MapMarginPoint(Point3D position, Point3D defaultDestination) {
		super(position);
		this.defaultDestination = defaultDestination;
	}
}
