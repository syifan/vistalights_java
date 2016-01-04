/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;
import com.logistics.simulator.business.IndustryType;

/**
 * @author yifansun
 *
 */
public class Dock extends Building {

	/**
	 * Name of the port
	 */
	private String name;
	
	/**
	 * Type of the dock
	 */
	private IndustryType industry;
	
	/**
	 * @param position
	 */
	public Dock(String name, Point3D position, IndustryType industry) {
		super(position);
		this.name = name;
		this.industry = industry;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public IndustryType getIndustry() {
		return industry;
	}

	/**
	 * @param type the type to set
	 */
	public void setIndustry(IndustryType industry) {
		this.industry = industry;
	}



}
