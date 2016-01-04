/**
 * Logistics server side
 */
package com.logistics.shared;

/**
 * @author Yifan Sun
 *
 */
public class Point2D extends Point3D {
	
	/**
	 * Constructor
	 */
	public Point2D(double x, double y){
		super(x, y, 0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%4.2f, %4.2f)", x, y);
	}

}
