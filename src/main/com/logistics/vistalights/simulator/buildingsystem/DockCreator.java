/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;
import com.logistics.simulator.map.Map;
import com.logistics.visualizer.viewport.DockViewObject;
import com.logistics.visualizer.viewport.DockViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * Dock creator is responsible for creating dock and its corresponding dock 
 * view object
 * @author yifan
 *
 */
public class DockCreator {

	protected ViewPort viewPort;
	
	protected DockFactory dockFactory;
	
	protected DockViewObjectFactory dockViewObjectFactory;
	
	protected Map map;
	
	/**
	 * @param viewPort
	 * @param dockFactory
	 * @param dockViewObjectFactory
	 * @param map
	 */
	public DockCreator(ViewPort viewPort, DockFactory dockFactory,
			DockViewObjectFactory dockViewObjectFactory, Map map) {
		super();
		this.viewPort = viewPort;
		this.dockFactory = dockFactory;
		this.dockViewObjectFactory = dockViewObjectFactory;
		this.map = map;
	}
	
	/**
	 * Create a dock
	 */
	public void createDock(String name, Point3D position, String type) {
		// Create dock
		Dock dock = dockFactory.produceDock(name, position, type);
		map.addDock(dock);
		dockViewObjectFactory.setDock(dock);
		
		// Create dock view object
		ViewObject dockViewObject = dockViewObjectFactory.produceViewObject();
		viewPort.addViewObject(dockViewObject);
	}
}
