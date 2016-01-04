/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

import processing.core.PApplet;

/**
 * @author yifan
 *
 */
public abstract class VisualizerObject 
	implements Renderable, MouseEventReceiver, KeyEventReceiver {

	/**
	 * The visualizer object
	 */
	protected PApplet visualizer;
	
	/**
	 * The layer where the 
	 */
	protected Layer layer;
	
	/**
	 * Mouse event handler
	 */
	protected MouseEventHandler mouseEventHandler;

	private KeyEventHandler keyEventHandler;
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventReceiver#setMouseEventHandler(com.logistics.visualizerbasic.MouseEventHandler)
	 */
	public void setMouseEventHandler(MouseEventHandler mouseEventHandler) {
		this.mouseEventHandler = mouseEventHandler;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#setKeyEventHandler(com.logistics.visualizerbasic.KeyEventHandler)
	 */
	public void setKeyEventHandler(KeyEventHandler handler) {
		this.keyEventHandler = handler;
	}

	/**
	 * @return the visualizer
	 */
	public PApplet getVisualizer() {
		return visualizer;
	}

	/**
	 * @param visualizer2
	 * @param canvas
	 */
	public VisualizerObject(PApplet visualizer, Layer layer) {
		super();
		this.visualizer = visualizer;
		this.layer = layer;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventReceiver#processMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	public void processMouseEvent(MouseEvent event) {
		if (this.mouseEventHandler != null) {
			if (event.getAction() == processing.event.MouseEvent.CLICK) {
				mouseEventHandler.mouseClicked(event);
			} else if (event.getAction() == processing.event.MouseEvent.PRESS) {
				mouseEventHandler.mousePressed(event);
			} else if (event.getAction() == processing.event.MouseEvent.RELEASE) {
				mouseEventHandler.mouseReleased(event);
			} else if (event.getAction() == processing.event.MouseEvent.WHEEL) {
				mouseEventHandler.mouseWheel(event);
			} else if (event.getAction() == processing.event.MouseEvent.DRAG) {
				mouseEventHandler.mouseDragged(event);
			}
			 
			// Finally, if the mouse event is still propagating, propagate it
			this.mouseEventHandler.propagateMouseEvent(event);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#processKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	public void processKeyEvent(KeyEvent event) {
		if (this.keyEventHandler != null) {
			if (event.getAction() == processing.event.KeyEvent.PRESS) {
				keyEventHandler.keyPressed(event);
			} else if (event.getAction() == processing.event.KeyEvent.RELEASE) {
				keyEventHandler.keyReleased(event);
			} else if (event.getAction() == processing.event.KeyEvent.TYPE) {
				keyEventHandler.keyTyped(event);
			}
		}
	}

	/**
	 * Determine if the mouse is in the element
	 * @return
	 */
	protected abstract boolean isMouseIn(MouseEvent event);
}
