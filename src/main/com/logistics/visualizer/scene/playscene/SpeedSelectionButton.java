/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class SpeedSelectionButton extends GuiElement {

	private String text = "";
	private boolean active = false;
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public SpeedSelectionButton(PApplet visualizer, GuiLayer gui,
			GuiContainer parent, double x, double y) {
		super(visualizer, gui, parent, x, y, 24, 24);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiElement#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		
		// Draw circle
		if (active) {
			canvas.fill(255);
		} else {
			canvas.fill(183);
		}
		canvas.stroke(183);
		canvas.strokeWeight(2);
		canvas.ellipseMode(PConstants.CORNER);
		canvas.ellipse((float) absX, (float) absY, 
				(float)width, (float)height);
		
		// Text
		canvas.fill(0);
		canvas.stroke(0);
		canvas.textSize(10);
		canvas.textAlign(PConstants.CENTER, PConstants.CENTER);
		canvas.text(text, (float) absX, (float) absY, 
				(float)width, (float)height);
	}

}
