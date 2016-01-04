/**
 * Logistics server side
 */
package com.logistics.simulator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.logistics.simulator.vehicle.Vehicle;

/**
 * A simulator is a singleton that have every element in the simulated world
 * 
 * @author Yifan Sun
 *
 */
public class SimulatorImpl implements Simulator {
	
	protected Map<Integer, Vehicle> vehicles = 
			new HashMap<Integer, Vehicle>();
	protected Terrain terrain;
	private Set<AddVehicleSubscriber> addVehicleSubscribers  = 
			new HashSet<AddVehicleSubscriber>();
	
	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	/**
	 * @param scheduler
	 */
	public SimulatorImpl() {
		super();
	}
	
	public void addVehicle(Vehicle vehicle) {
		synchronized(vehicles) {
			this.vehicles.put(vehicle.getId(), vehicle);
		}
		synchronized(addVehicleSubscribers) {
			for (AddVehicleSubscriber subscriber : addVehicleSubscribers) {
				subscriber.addVehicleNotify(vehicle);
			}
		}
	}
	
	public Map<Integer, Vehicle> getVehicles() {
		return vehicles;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.Simulator#addAddVehicleSubscriber(com.logistics.simulator.AddVehicleSubscriber)
	 */
	@Override
	public void addAddVehicleSubscriber(AddVehicleSubscriber subscriber) {
		synchronized(addVehicleSubscribers) {
			addVehicleSubscribers.add(subscriber);
		}
	}
	
}
