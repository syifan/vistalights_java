/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.business.IndustryType;
import com.logistics.simulator.vehicle.cargo.CargoContainer;
import com.logistics.simulator.vehicle.scheduler.Schedule;
import com.logistics.simulator.vehicle.task.TaskRunner;
import com.logistics.visualizer.viewport.ViewObject;

/**
 * Vehicle is a ship that moves on the maps.
 * This class is responsible 
 * @author Yifan Sun
 *
 */
public class VehicleImpl implements Vehicle {
	protected int id;
	protected Point3D position;
	protected Point3D heading;
	protected Point3D size;
	protected int unloadNodeId;
	protected boolean unloaded;
	protected int leaveNodeId;
	protected double speed = 3.0;
	protected int priority;
	protected Schedule schedule;
	protected TaskRunner taskRunner;
	protected ViewObject viewObject;
	protected IndustryType industryType;
	protected CargoContainer cargoContainer;
	
	/**
	 * @param taskRunner the taskRunner to set
	 */
	public void setTaskRunner(TaskRunner taskRunner) {
		this.taskRunner = taskRunner;
	}

	/**
	 * Vehicle implement id
	 * @param id
	 */
	public VehicleImpl(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getPosition()
	 */
	@Override
	public Point3D getPosition() {
		return position;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setPosition(com.logistics.shared.Point3D)
	 */
	@Override
	public void setPosition(Point3D position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getHeading()
	 */
	@Override
	public Point3D getHeading() {
		return heading;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setHeading(com.logistics.shared.Point3D)
	 */
	@Override
	public void setHeading(Point3D heading) {
		this.heading = heading;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getSize()
	 */
	@Override
	public Point3D getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setSize(com.logistics.shared.Point3D)
	 */
	@Override
	public void setSize(Point3D size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getUnloadNodeId()
	 */
	@Override
	public int getUnloadNodeId() {
		return unloadNodeId;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setUnloadNodeId(int)
	 */
	@Override
	public void setUnloadNodeId(int unloadNodeId){
		this.unloadNodeId = unloadNodeId;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#hasUnloaded()
	 */
	@Override
	public boolean hasUnloaded() {
		
		if(Math.abs(this.cargoContainer.getTonnage()) < 10) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getLeaveNodeId()
	 */
	@Override
	public int getLeaveNodeId() {
		return leaveNodeId;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setLeaveNodeId(int)
	 */
	@Override
	public void setLeaveNodeId(int leaveNodeId) {
		this.leaveNodeId = leaveNodeId;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getSpeed()
	 */
	@Override
	public double getSpeed() {
		return speed;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setSpeed(double)
	 */
	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getPriority()
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setPriority(int)
	 */
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#tick()
	 */
	@Override
	public void tick() {
		
		cargoContainer.getCargoScoreCounter().tick();
	}

	/**
	 * @return
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setSchedule(com.logistics.simulator.vehicle.Schedule)
	 */
	@Override
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#leave()
	 */
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setViewObject(com.logistics.visualizer.viewport.ViewObject)
	 */
	@Override
	public void setViewObject(ViewObject viewObject) {
		this.viewObject = viewObject;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getViewObject()
	 */
	@Override
	public ViewObject getViewObject() {
		return viewObject;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getCargoContainer()
	 */
	@Override
	public CargoContainer getCargoContainer() {
		return cargoContainer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setCargoContainer(com.logistics.simulator.vehicle.CargoContainer)
	 */
	@Override
	public void setCargoContainer(CargoContainer cargoContainer) {
		this.cargoContainer = cargoContainer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#getIndustryType()
	 */
	@Override
	public IndustryType getIndustryType() {
		return industryType;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.Vehicle#setInsdustryType(com.logistics.simulator.business.IndustryType)
	 */
	@Override
	public void setInsdustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

}
