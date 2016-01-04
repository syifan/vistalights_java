/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.map.Map;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class VehicleViewObjectFactory extends ViewObjectFactory {

	private Vehicle vehicle;
	private ViewPortCamera camera;
	private Map map;

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public VehicleViewObjectFactory(Visualizer visualizer, ViewPort viewPort, 
			ViewPortCamera camera, Map map) {
		super(visualizer, viewPort);
		this.camera = camera;
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.ViewObjectFactory#produceViewPortObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		VehicleViewObject vehicleViewObject = new VehicleViewObject(
				visualizer, viewPort, vehicle);
		camera.addPositionSubscriber(vehicleViewObject);
		
		/*
		// Create click event handler
		VehicleTaskFactory vehicleTaskFactory = new VehicleTaskFactory();
		VehicleViewObjectMouseEventHandler vehicleViewObjectMouseEventHandler = 
				new VehicleViewObjectMouseEventHandler(vehicle, 
						vehicleViewObject, 
						vehicleTaskFactory, viewPort, map);
		vehicleViewObject.setMouseEventHandler(
				vehicleViewObjectMouseEventHandler);
		*/
		
		// Return vehicle view object
		return vehicleViewObject;
	}

}
