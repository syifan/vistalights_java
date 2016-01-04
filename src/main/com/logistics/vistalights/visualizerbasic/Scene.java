/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;

import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class Scene 
	implements Renderable, MouseEventReceiver, KeyEventReceiver {
	
	/**
	 * The visualizer
	 */
	protected PApplet visualizer;
	
	/**
	 * A list of layers
	 */
	protected ArrayList<Layer> layers = new ArrayList<Layer>();

	/**
	 * Mouse event handler
	 */
	protected MouseEventHandler mouseEventHandler;

	/**
	 * Key event handler
	 */
	private KeyEventHandler keyEventHandler;

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public Scene(PApplet visualizer) {
		this.visualizer = visualizer;
	}
	
	/**
	 * Add an layer to the scene, the layer added first would be rendered 
	 * at the bottom
	 */
	public void addLayer(Layer layer) {
		synchronized(layers) {
			this.layers.add(layer);
		}
	}
	
	/**
	 * Get all layers of the scene
	 */
	public ArrayList<Layer> getLayers() {
		return layers;
	}

	/**
	 * Render the scene
	 */
	public void render() {
		synchronized(layers) {
			for (Layer layer : layers) {
				layer.render();
				PGraphics canvas = layer.getCanvas();
				visualizer.image(canvas, 0, 0);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventReceiver#processMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	public void processMouseEvent(MouseEvent event) {
		if (this.mouseEventHandler != null) {
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
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#processKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void processKeyEvent(KeyEvent event) {
		if (this.keyEventHandler != null) {
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

}
