/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public abstract class ViewObjectFactory{

	protected Visualizer visualizer;
	/**
	 * @param visualizer
	 * @param viewPort
	 */
	public ViewObjectFactory(Visualizer visualizer, ViewPort viewPort) {
		super();
		this.visualizer = visualizer;
		this.viewPort = viewPort;
	}

	protected ViewPort viewPort;
	
	/**
	 * Produce the view port object
	 * @return
	 */
	public abstract ViewObject produceViewObject();

}
