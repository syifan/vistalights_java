/**
 * Logistics server side
 */
package com.logistics.simulator.buildingsystem;

import com.logistics.shared.Point3D;
import com.logistics.simulator.map.Map;
import com.logistics.visualizer.viewport.MapMarginPointViewObject;
import com.logistics.visualizer.viewport.MapMarginPointViewObjectFactory;
import com.logistics.visualizer.viewport.ViewObject;
import com.logistics.visualizer.viewport.ViewPort;

/**
 * A map margin point creator is responsible for creating a map margin point 
 * and add it to a map, as well as creating the map margin point view object 
 * and add it to the view port.
 * @author yifansun
 *
 */
public class MapMarginPointCreator {
	protected ViewPort viewPort;
	
	protected MapMarginPointFactory mapMarginPointFactory;
	
	protected MapMarginPointViewObjectFactory mapMarginPointViewObjectFactory;
	
	protected Map map;
	
	/**
	 * @param viewPort
	 * @param mapMarginPointFactory
	 * @param mapMarginPointViewObjectFactory
	 * @param map
	 */
	public MapMarginPointCreator(ViewPort viewPort,
			MapMarginPointFactory mapMarginPointFactory,
			MapMarginPointViewObjectFactory mapMarginPointViewObjectFactory,
			Map map) {
		super();
		this.viewPort = viewPort;
		this.mapMarginPointFactory = mapMarginPointFactory;
		this.mapMarginPointViewObjectFactory = mapMarginPointViewObjectFactory;
		this.map = map;
	}

	public void createMapMarginPoint(Point3D position, 
			Point3D defaultDestination) {
		// Create map margin point
		MapMarginPoint mapMarginPoint = 
				mapMarginPointFactory.produceMapMarginPoint(position, 
				defaultDestination);
		map.addMapMarginPoint(mapMarginPoint);
		
		// Create corresponding view object
		mapMarginPointViewObjectFactory.setMapMarginPoint(mapMarginPoint);
		ViewObject mapMarginPointViewObject = 
				mapMarginPointViewObjectFactory.produceViewObject();
		viewPort.addViewObject(mapMarginPointViewObject);
	}
}
