/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizerbasic.MouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiContainerMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;

import processing.core.PApplet;

/**
 * @author yifansun
 *
 */
public class SpeedControllerFactory {
	private PApplet visualizer;
	private GuiLayer gui;
	private Scheduler scheduler;
	private GuiContainer container;

	/**
	 * @param container the container to set
	 */
	public void setContainer(GuiContainer container) {
		this.container = container;
	}

	/**
	 * @param visualizer
	 * @param gui
	 * @param scheduler
	 */
	public SpeedControllerFactory(PApplet visualizer, GuiLayer gui, 
			GuiContainer container, Scheduler scheduler) {
		super();
		this.visualizer = visualizer;
		this.gui = gui;
		this.container = container;
		this.scheduler = scheduler;
	}

	/**
	 * Produce speed controller
	 * @return
	 */
	public SpeedController produceSpeedController() {
		SpeedController speedController = new SpeedController(
				visualizer, gui, container, scheduler);
		MouseEventHandler speedControllerMouseEventHandler = 
				new GuiContainerMouseEventHandler(speedController);
		speedController.setMouseEventHandler(speedControllerMouseEventHandler);
		
		SpeedSelectionButton button3X = new SpeedSelectionButton(
				visualizer, gui, speedController, 10, 2);
		button3X.setText("3X");
		MouseEventHandler button3XMouseHandler = 
				new SpeedSelectionButtonMouseEventHandler(button3X, 
						scheduler, 1000);
		button3X.setMouseEventHandler(button3XMouseHandler);
		speedController.addSubGuiElement(button3X);
		
		SpeedSelectionButton button2X = new SpeedSelectionButton(
				visualizer, gui, speedController, 38, 0);
		button2X.setText("2X");
		MouseEventHandler button2XMouseHandler = 
				new SpeedSelectionButtonMouseEventHandler(button2X, scheduler, 500);
		button2X.setMouseEventHandler(button2XMouseHandler);
		speedController.addSubGuiElement(button2X);
		
		SpeedSelectionButton button1X = new SpeedSelectionButton(
				visualizer, gui, speedController, 60, 15);
		button1X.setText("1X");
		MouseEventHandler button1XMouseHandler = 
				new SpeedSelectionButtonMouseEventHandler(button1X, scheduler, 100);
		button1X.setMouseEventHandler(button1XMouseHandler);
		speedController.addSubGuiElement(button1X);
		
		SpeedSelectionButton buttonPause = new SpeedSelectionButton(
				visualizer, gui, speedController, 65, 40);
		buttonPause.setText("II");
		MouseEventHandler buttonPauseMouseHandler = 
				new SpeedSelectionButtonMouseEventHandler(buttonPause, 
						scheduler, 0);
		buttonPause.setMouseEventHandler(buttonPauseMouseHandler);
		speedController.addSubGuiElement(buttonPause);
		
		return speedController;
	}
}
