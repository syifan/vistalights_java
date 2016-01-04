/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.shared.Point2D;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;
import com.logistics.visualizerbasic.Layer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;
import com.logistics.visualizerbasic.VisualizerObject;

/**
 * @author yifansun
 *
 */
public class ViewPortImpl implements ViewPort {
	
	/**
	 * List of objects to be shown in the visualizer
	 */
	protected Set<ViewObject> viewObjects = new HashSet<ViewObject>();
	
	/**
	 * camera object
	 */
	protected ViewPortCamera camera;

	/**
	 * The canvas 
	 */
	protected PGraphics canvas;

	/**
	 * The visualizer
	 */
	protected Visualizer visualizer;

	/**
	 * The mouse event handler
	 */
	protected MouseEventHandler mouseEventHandler;

	/**
	 * The key event handler
	 */
	protected KeyEventHandler keyEventHandler;
	
	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewPort#getCamera()
	 */
	@Override
	public ViewPortCamera getCamera() {
		return camera;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewPort#setCamera(com.logistics.visualizer.viewport.ViewPortCamera)
	 */
	@Override
	public void setCamera(ViewPortCamera camera) {
		this.camera = camera;
	}

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public ViewPortImpl(Visualizer visualizer) {
		this.visualizer = visualizer;
		this.canvas = visualizer.createGraphics(
				visualizer.width, 
				visualizer.height,
				PConstants.P3D);
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewPort#addViewObject(com.logistics.visualizer.viewport.ViewObject)
	 */
	@Override
	public void addViewObject(ViewObject viewObject) {
		synchronized(viewObjects) {
			this.viewObjects.add(viewObject);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		canvas.beginDraw();
		canvas.background(255);
		canvas.ambientLight(0,  0, 255);
		camera.render();
		synchronized(viewObjects) {
			for (VisualizerObject viewObject : viewObjects) {
				viewObject.render();
			}
		}
		canvas.endDraw();
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventReceiver#processMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void processMouseEvent(MouseEvent event) {
		if (mouseEventHandler != null) {
			mouseEventHandler.propagateMouseEvent(event);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventReceiver#setMouseEventHandler(com.logistics.visualizerbasic.MouseEventHandler)
	 */
	@Override
	public void setMouseEventHandler(MouseEventHandler handler) {
		this.mouseEventHandler = handler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.Layer#getCanvas()
	 */
	@Override
	public PGraphics getCanvas() {
		return canvas;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.Layer#mousePosition(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public Point2D mousePosition(MouseEvent event) {
		double mouseX = (event.getX() - ((double)canvas.width / 2));
		double mouseY = (event.getY() - ((double)canvas.height / 2));
		
		double distanceMousePlane = (canvas.height / 2) / Math.tan((float) (PConstants.PI/6.0));
		
		double mouseOnMapX = camera.getPosition().getX() + mouseX * camera.getPosition().getZ() / distanceMousePlane;
		double mouseOnMapY = camera.getPosition().getY() + mouseY * camera.getPosition().getZ() / distanceMousePlane;
		
		return new Point2D(mouseOnMapX, mouseOnMapY);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#processKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void processKeyEvent(KeyEvent event) {
		if (keyEventHandler != null) {
			keyEventHandler.propagateKeyEvent(event);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#setKeyEventHandler(com.logistics.visualizerbasic.KeyEventHandler)
	 */
	@Override
	public void setKeyEventHandler(KeyEventHandler handler) {
		this.keyEventHandler = handler;
	} 
	
	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewPort#removeViewObject(com.logistics.visualizer.viewport.ViewObject)
	 */
	@Override
	public void removeViewObject(ViewObject viewObject) {
		this.viewObjects.remove(viewObject);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.viewport.ViewPort#getViewObjects()
	 */
	@Override
	public Set<ViewObject> getViewObjects() {
		return this.viewObjects;
	}

}
