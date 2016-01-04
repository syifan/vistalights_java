/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;
import com.logistics.simulator.business.IndustryType;

/**
 * @author yifan
 *
 */
public class DockFactory {
	
	public Dock produceDock(String name, Point3D position, String type) {
		return new Dock(name, position, 
				IndustryType.valueOf(type.toUpperCase()));
	}
	
}
