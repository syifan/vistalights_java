/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.organizescene;

import processing.core.PGraphics;

import com.logistics.gamelogic.organizelogiccontroller.OrganizeLogicController;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class StartGameButtonFactory {

	/**
	 * @param visualizer
	 * @param canvas
	 * @param gui
	 * @param organizeLogicController
	 */
	public StartGameButtonFactory(Visualizer visualizer, GuiLayer guiLayer,
			GuiContainer guiContainer, OrganizeLogicController organizeLogicController) {
		super();
		this.visualizer = visualizer;
		this.guiLayer = guiLayer;
		this.guiContainer = guiContainer;
		this.organizeLogicController = organizeLogicController;
	}

	private Visualizer visualizer;
	private GuiLayer guiLayer;
	private GuiContainer guiContainer;
	private OrganizeLogicController organizeLogicController;

	public StartGameButton produceStartGameButton() {
		// Create button
		StartGameButton button = new StartGameButton(visualizer, guiLayer, 
				guiContainer);
		
		// Create button click event handler
		StartGameButtonMouseEventHandler handler = new 
				StartGameButtonMouseEventHandler(
						organizeLogicController, button);
		
		// Set the event handler
		button.setMouseEventHandler(handler);
		
		return button;
	}
	
}
