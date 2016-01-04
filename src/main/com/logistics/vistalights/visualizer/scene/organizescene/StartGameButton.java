/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.organizescene;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.Button;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class StartGameButton extends Button {

	/**
	 * @param visualizer
	 * @param canvas
	 * @param parent
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StartGameButton(Visualizer visualizer, GuiLayer layer,
			GuiContainer parent) {
		super(visualizer, layer, parent, "Start Game", 100, 50, 100, 50);
		this.setAnchorPoint(3, 3);
	}
}
