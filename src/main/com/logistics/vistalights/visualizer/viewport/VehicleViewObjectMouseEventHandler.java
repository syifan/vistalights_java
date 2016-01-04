/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.map.Map;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifansun
 *
 */
public class VehicleViewObjectMouseEventHandler implements MouseEventHandler {

	private Vehicle vehicle;
	private VehicleViewObject vehicleViewObject;
	private ViewPort viewPort;
	private Map map;
	private boolean isDragging = false;

	/**
	 * Constructor
	 * @param vehicleViewObject
	 */
	public VehicleViewObjectMouseEventHandler(
			Vehicle vehicle, 
			VehicleViewObject vehicleViewObject, 
			ViewPort viewPort, 
			Map map) {
		super();
		this.vehicle = vehicle;
		this.vehicleViewObject = vehicleViewObject;
		//this.vehicleTaskFactory = vehicleTaskFactory;
		this.viewPort = viewPort;
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		if (vehicleViewObject.isMouseIn(event)) {
			if (vehicleViewObject.isSelected) {
				vehicleViewObject.isSelected = false;
			} else {
				vehicleViewObject.isSelected = true;
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mousePressed(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		/*
		if (vehicleViewObject.isMouseIn(event)) {
			this.isDragging = true;
			this.vehicle.getTaskRunner().clearTasks();
		}
		*/
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseReleased(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		this.isDragging = false;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseDragged(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		/*
		if (isDragging) {
			Point2D nextPoint = viewPort.mousePosition(event);
			
			// If not water, stop dragging
			if (!map.isWater(nextPoint)) {
				this.isDragging = false;
				return;
			}
			
			// Create MOVETO task
			VehicleTask task = this.vehicleTaskFactory.produceVehicleTask(
					VehicleTaskType.MOVETO, nextPoint);
			this.vehicle.getTaskRunner().addTask(task);
			
			// Traverse docks to check if the point is close to a dock
			// FIXME: this functionality depends on dock view objects rather
			// than the maps.
			ArrayList<Dock> docks = map.getDocks();
			synchronized(docks) {
				for (Dock dock : docks) {
					double distance  = dock.getPosition().distanceTo(
							nextPoint);
					if (!(vehicle.getStatus() == VehicleStatus.MOORED) && distance < 750) {
						
						// Dock properly
						task = this.vehicleTaskFactory.produceVehicleTask(
								VehicleTaskType.DOCK, dock.getPosition());
						this.vehicle.getTaskRunner().addTask(task);
						
						// Unloading only when industry matches
						if (vehicle.getIndustry() == dock.getIndustry()) {
							task = this.vehicleTaskFactory.produceVehicleTask(
									VehicleTaskType.UNLOADING, dock.getPosition());
							this.vehicle.getTaskRunner().addTask(task);
						}
						
						// Stop dragging
						this.isDragging = false;
						break;
					}
				}
			}
		}
		*/
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseWheel(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseWheel(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
