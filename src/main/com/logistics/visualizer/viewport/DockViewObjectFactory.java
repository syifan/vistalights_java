/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.buildingsystem.Dock;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class DockViewObjectFactory extends ViewObjectFactory {

	protected Dock dock;
	
	/**
	 * @param dock the dock to set
	 */
	public void setDock(Dock dock) {
		this.dock = dock;
	}

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public DockViewObjectFactory(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, viewPort);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.ViewObjectFactory#produceViewObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		DockViewObject dockViewObject =  new DockViewObject(visualizer, 
				viewPort, dock);
		return dockViewObject;
	}

}
