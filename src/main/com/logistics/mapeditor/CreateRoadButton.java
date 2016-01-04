/**
 * Logistics server side
 */
package com.logistics.mapeditor;

import processing.core.PApplet;

import com.logistics.visualizerbasic.gui.Button;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifan
 *
 */
public class CreateRoadButton extends Button {

	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public CreateRoadButton(PApplet visualizer, GuiLayer gui,
			GuiContainer parent) {
		super(visualizer, gui, parent, "Road", 20, 20, 50, 50);
		this.setAnchorPoint(1, 3);
	}

}
