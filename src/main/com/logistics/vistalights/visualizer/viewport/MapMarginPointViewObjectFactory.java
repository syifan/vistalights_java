/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.simulator.buildingsystem.MapMarginPoint;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public class MapMarginPointViewObjectFactory extends ViewObjectFactory {

	protected MapMarginPoint mapMarginPoint;
	
	/**
	 * @param mapMarginPoint the mapMarginPoint to set
	 */
	public void setMapMarginPoint(MapMarginPoint mapMarginPoint) {
		this.mapMarginPoint = mapMarginPoint;
	}

	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public MapMarginPointViewObjectFactory(Visualizer visualizer,
			ViewPort viewPort) {
		super(visualizer, viewPort);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.ViewObjectFactory#produceViewObject()
	 */
	@Override
	public ViewObject produceViewObject() {
		return new MapMarginPointViewObject(visualizer, viewPort, 
				mapMarginPoint);
	}

}
