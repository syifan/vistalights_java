/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.startscene;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.Button;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifan
 *
 */
public class StartButton extends Button {

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
	public StartButton(Visualizer visualizer, GuiLayer gui,
			GuiContainer parent) {
		super(visualizer, gui, parent, "Host Game", 0, 150, 200, 50);
		this.setAnchorPoint(2, 2);
	}

}
