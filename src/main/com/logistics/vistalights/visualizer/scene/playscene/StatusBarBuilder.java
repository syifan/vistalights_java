/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.visualizerbasic.MouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiContainerMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;

import processing.core.PApplet;

/**
 * @author yifansun
 *
 */
public class StatusBarBuilder {
	
	private PApplet visualizer;
	private GuiLayer gui;
	private GuiContainer parent;
	private TimeLabelFactory timeLabelFactory;
	private SpeedControllerFactory speedControllerFactory;
	private BudgetScoreMonitorFactory budgetScoreMonitorFactory;
	
	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 */
	public StatusBarBuilder(PApplet visualizer, GuiLayer gui,
			GuiContainer parent, TimeLabelFactory timeLabelFactory,
			SpeedControllerFactory speedControllerFactory,
			BudgetScoreMonitorFactory budgetScoreMonitorFactory) {
		super();
		this.visualizer = visualizer;
		this.gui = gui;
		this.parent = parent;
		this.timeLabelFactory = timeLabelFactory;
		this.speedControllerFactory = speedControllerFactory;
		this.budgetScoreMonitorFactory = budgetScoreMonitorFactory;
	}

	/**
	 * Build the status bar
	 * @return
	 */
	StatusBar buildStatusBar() {
		StatusBar statusBar = new StatusBar(visualizer, gui, parent);
		MouseEventHandler mouseEventHandler = 
				new GuiContainerMouseEventHandler(statusBar);
		statusBar.setMouseEventHandler(mouseEventHandler);
		
		// Create time label
		timeLabelFactory.setContainer(statusBar);
		TimeLabel timeLabel = timeLabelFactory.produceTimeLabel();
		statusBar.addSubGuiElement(timeLabel);
		
		// Create speed controller
		speedControllerFactory.setContainer(statusBar);
		SpeedController speedController = 
				speedControllerFactory.produceSpeedController();
		statusBar.addSubGuiElement(speedController);
		
		// Create buget score monitor
		budgetScoreMonitorFactory.setContainer(statusBar);
		BudgetScoreMonitor monitor = 
				budgetScoreMonitorFactory.produceBudgetScoreMonitor();
		statusBar.addSubGuiElement(monitor);
		
		return statusBar;
	}
}
