/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

import com.logistics.shared.Point3D;
import com.logistics.simulator.business.IndustryType;
import com.logistics.simulator.vehicle.cargo.CargoContainer;
import com.logistics.simulator.vehicle.scheduler.Schedule;
import com.logistics.visualizer.viewport.ViewObject;

/**
 * @author Yifan
 *
 */
public interface Vehicle {
	public int getId();
	
	public Point3D getPosition();
	public void setPosition(Point3D position);
	
	public Point3D getHeading();
	public void setHeading(Point3D heading);
	
	public Point3D getSize();
	public void setSize(Point3D size);
	
	public double getSpeed();
	public void setSpeed(double speed);
	
	public int getPriority();
	public void setPriority(int priority);
	
	public int getUnloadNodeId();
	public void setUnloadNodeId(int nodeId);
	
	public boolean hasUnloaded();
	
	public int getLeaveNodeId();
	public void setLeaveNodeId(int nodeId);
	
	public void setSchedule(Schedule schedule);
	public Schedule getSchedule();
	
	public void tick();

	/**
	 * The vehicle leaves the map
	 */
	public void leave();

	public ViewObject getViewObject();
	public void setViewObject(ViewObject viewObject);
	
	public CargoContainer getCargoContainer();
	public void setCargoContainer(CargoContainer cargoContainer);
	
	public IndustryType getIndustryType();
	public void setInsdustryType(IndustryType industryType);
}
