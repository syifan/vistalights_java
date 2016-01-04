/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;

/**
 * A building is an object that construct by the user
 * @author Yifan Sun
 *
 */
abstract public class Building {
	
	/**
	 * The position of the building
	 */
	protected Point3D position;
	
	/**
	 * @return the position
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Point3D position) {
		this.position = position;
	}

	/**
	 * Constructor
	 * @param node the node that this building possess
	 */
	public Building(Point3D position){
		this.position = position;
	}

}
