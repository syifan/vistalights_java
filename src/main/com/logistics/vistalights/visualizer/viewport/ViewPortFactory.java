/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public class ViewPortFactory {
	
	private Visualizer visualizer;

	/**
	 * Constructor
	 * @param visualizer
	 */
	public ViewPortFactory(Visualizer visualizer) {
		super();
		this.visualizer = visualizer;
	}

	/**
	 * Produce view port
	 * @return
	 */
	public ViewPort procudeViewPort() {
		ViewPort viewPort = new ViewPortImpl(visualizer);
		
		// Create camera
		ViewPortCamera camera = new ViewPortCamera(visualizer, viewPort);
		ViewPortCameraMouseEventHandler cameraMouseEventHandler = 
				new ViewPortCameraMouseEventHandler(camera);
		camera.setMouseEventHandler(cameraMouseEventHandler);
		ViewPortCameraKeyEventHandler cameraKeyEventHandler = 
				new ViewPortCameraKeyEventHandler(camera);
		camera.setKeyEventHandler(cameraKeyEventHandler);
		viewPort.setCamera(camera);
		
		// Create mouse event handler
		ViewPortMouseEventHandler mouseEventHandler = 
				new ViewPortMouseEventHandler(viewPort);
		viewPort.setMouseEventHandler(mouseEventHandler);
		
		// Create key event handler
		ViewPortKeyEventHandler keyEventHandler = 
				new ViewPortKeyEventHandler(viewPort);
		viewPort.setKeyEventHandler(keyEventHandler);
		
		// Return
		return viewPort;
	}
}
