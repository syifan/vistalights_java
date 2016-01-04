/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.shared.Point2D;
import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;
import com.logistics.visualizerbasic.Layer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifan
 *
 */
public class GuiLayer implements GuiContainer, Layer {
	
	/**
	 * The canvas to draw gui element on
	 */
	protected PGraphics canvas;
	
	/**
	 * A list of gui elements
	 */
	protected Set<GuiElement> elements = new HashSet<GuiElement>();

	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getSubGuiElements()
	 */
	@Override
	public Set<GuiElement> getSubGuiElements() {
		return elements;
	}

	/**
	 * The visualizer object
	 */
	private PApplet visualizer;

	/**
	 * Mouse event handler
	 */
	protected MouseEventHandler mouseEventHandler;

	/**
	 * Key event handelr
	 */
	protected KeyEventHandler keyEventHandler;

	/**
	 * @param visualizer
	 */
	public GuiLayer(PApplet visualizer) {
		this.visualizer = visualizer;
		this.canvas = visualizer.createGraphics(visualizer.width, visualizer.height,
				PConstants.P2D);
		//this.canvas.smooth(16);
	}

	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.Renderable#render()
	 */
	public void render() {
		canvas.beginDraw();
		for (GuiElement element : elements) {
			element.render();
		}
		canvas.endDraw();
	}


	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#addSubGuiElement(com.logistics.visualizerbasic.gui.GuiElement)
	 */
	public void addSubGuiElement(GuiElement element) {
		this.elements.add(element);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getX()
	 */
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getY()
	 */
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getWidth()
	 */
	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return visualizer.width;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getHeight()
	 */
	@Override
	public double getHeight() {
		return visualizer.height;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.Layer#getCanvas()
	 */
	@Override
	public PGraphics getCanvas() {
		return canvas;
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
	 * @see com.logistics.visualizerbasic.Layer#mousePosition()
	 */
	@Override
	public Point2D mousePosition(MouseEvent event) {
		return new Point2D(event.getX(), event.getY());
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#processKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void processKeyEvent(KeyEvent event) {
		keyEventHandler.propagateKeyEvent(event);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventReceiver#setKeyEventHandler(com.logistics.visualizerbasic.KeyEventHandler)
	 */
	@Override
	public void setKeyEventHandler(KeyEventHandler handler) {
		this.keyEventHandler = handler;
	}

	

}
