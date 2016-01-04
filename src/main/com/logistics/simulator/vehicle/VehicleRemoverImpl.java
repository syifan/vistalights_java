/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.logistics.simulator.Simulator;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * @author Yifan
 *
 */
public class VehicleRemoverImpl implements VehicleRemover {
	
	protected Simulator simulator;
	protected ViewPort viewPort;

	/**
	 * @param simulator
	 * @param viewPort
	 */
	public VehicleRemoverImpl(Simulator simulator, ViewPort viewPort) {
		super();
		this.simulator = simulator;
		this.viewPort = viewPort;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleRemover#removeVehicle()
	 */
	@Override
	public void removeVehicle(Vehicle vehicle) {
		Map<Integer, Vehicle> vehicles = simulator.getVehicles();
		synchronized(vehicles) {
			Iterator<Vehicle> it = vehicles.values().iterator();
			while(it.hasNext()) {
				Vehicle vehicleInList = it.next();
				if (vehicle == vehicleInList) {
					// Remove view object first
					ViewObject viewObject = vehicle.getViewObject();
					viewPort.removeViewObject(viewObject);
					
					// Remove the vehicle
					it.remove();
				}
			}
		}

	}

}
