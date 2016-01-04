/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class Button extends GuiElement {
	
	/**
	 * The text to present on the button
	 */
	protected String text;
	
	/**
	 * Determines if the button is disabled 
	 */
	protected boolean disabled;

	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param visualizer
	 * @param canvas
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(PApplet visualizer, GuiLayer gui, GuiContainer parent,
			String text, double x, double y, double width, double height) {
		super(visualizer, gui, parent, x, y, width, height);
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		canvas.stroke(0);
		canvas.fill(255);
		canvas.rect((float)absX, (float)absY, (float)width, (float)height, 
				(float)3.0, (float)3.0, (float)3.0, (float)3.0);
		
		canvas.fill(0, 255, 0);
		canvas.textSize((float) (0.4 * height));
		canvas.textAlign(PConstants.CENTER, PConstants.CENTER);
		canvas.text(text, (float)absX, (float)absY, (float)width, (float)height);
	}
	
	/**
	 * Set the button to be disabled
	 */
	public void disable() {
		this.disabled = true;
	}

}
