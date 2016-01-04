/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import java.util.HashSet;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PGraphics;

import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class StatusBar extends GuiElement implements GuiContainer {
	
	private Set<GuiElement> elements = new HashSet<GuiElement>();

	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StatusBar(PApplet visualizer, GuiLayer gui, GuiContainer parent) {
		super(visualizer, gui, parent, 0, 0, parent.getWidth(), 100);
		this.setAnchorPoint(1, 3);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getX()
	 */
	@Override
	public double getX() {
		return absX;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getY()
	 */
	@Override
	public double getY() {
		return absY;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getWidth()
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getHeight()
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#addSubGuiElement(com.logistics.visualizerbasic.gui.GuiElement)
	 */
	@Override
	public void addSubGuiElement(GuiElement guiElement) {
		synchronized(elements) {
			elements.add(guiElement);
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiElement#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		canvas.fill(36, 55, 78);
		canvas.noStroke();
		canvas.rect((float)absX, (float)(absY + 50), 
				(float) width, 50);
		
		synchronized(elements) {
			for (GuiElement element : elements) {
				element.render();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getSubGuiElements()
	 */
	@Override
	public Set<GuiElement> getSubGuiElements() {
		return elements;
	}

	
}
