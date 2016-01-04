/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

import com.logistics.shared.Point2D;

import processing.core.PGraphics;

/**
 * A layer encapsulates a layer of image to be paste in the visualizer. 
 * Layer has its own canvas, which is an PGraphics
 * @author yifansun
 *
 */
public interface Layer 
	extends Renderable, MouseEventReceiver, KeyEventReceiver {

	/**
	 * Retrieve the canvas of the layer
	 * @return
	 */
	public PGraphics getCanvas();

	/**
	 * @param event
	 * @return
	 */
	Point2D mousePosition(MouseEvent event);
	
}
