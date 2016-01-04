/**
 * Logistics server side
 */
package com.logistics.apisystem;

import com.logistics.simulator.AddVehicleSubscriber;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleSerializer;

/**
 * @author yifan
 *
 */
public class AddVehicleNotifier implements AddVehicleSubscriber {

	private VehicleSerializer vehicleSerializer;
	private ApiManager apiManager;

	/**
	 * @param apiManager
	 * @param serializer
	 */
	public AddVehicleNotifier(ApiManager apiManager,
			VehicleSerializer vehicleSerializer) {
		this.apiManager = apiManager;
		this.vehicleSerializer = vehicleSerializer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.AddVehicleSubscriber#addVehicleNotify(com.logistics.simulator.vehicle.Vehicle)
	 */
	@Override
	public void addVehicleNotify(Vehicle vehicle) {
		String vehicleString = vehicleSerializer.toString(vehicle);
		String data = String.format(
				"{"
				+ "\"action\": \"ship create\","
				+ "\"vehicle\": %s"
				+ "}", 
				vehicleString
			);
		apiManager.broadcast(data);

	}

}
