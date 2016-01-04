/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.vehicle.Vehicle;

/**
 * @author Yifan
 *
 */
public class VehicleViewObjectProducerImpl implements VehicleViewObjectProducer {

	private VehicleViewObjectFactory vehicleViewObjectFactory;
	private ViewPort viewPort;

	public VehicleViewObjectProducerImpl(
			ViewPort viewPort,
			VehicleViewObjectFactory vehicleViewObjectFactory) {
		this.viewPort = viewPort;
		this.vehicleViewObjectFactory = vehicleViewObjectFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.AddVehicleSubscriber#addVehilceNotify(com.logistics.simulator.vehicle.Vehicle)
	 */
	@Override
	public void addVehicleNotify(Vehicle vehicle) {
		vehicleViewObjectFactory.setVehicle(vehicle);
		ViewObject viewObject = vehicleViewObjectFactory.produceViewObject();
		viewPort.addViewObject(viewObject);
	}

}
