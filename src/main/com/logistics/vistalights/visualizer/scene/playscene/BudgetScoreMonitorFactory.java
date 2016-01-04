/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.simulator.ScoreManager;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiLayer;

import processing.core.PApplet;

/**
 * @author yifan
 *
 */
public class BudgetScoreMonitorFactory {
	private PApplet visualizer;
	private GuiLayer gui;
	private GuiContainer container;
	private ScoreManager score;

	/**
	 * @param visualizer
	 * @param gui
	 * @param container
	 * @param score
	 */
	public BudgetScoreMonitorFactory(PApplet visualizer, GuiLayer gui,
			GuiContainer container, ScoreManager score) {
		super();
		this.visualizer = visualizer;
		this.gui = gui;
		this.container = container;
		this.score = score;
	}

	public BudgetScoreMonitor produceBudgetScoreMonitor() {
		BudgetScoreMonitor monitor = new BudgetScoreMonitor(visualizer, 
				gui, container, score);
		return monitor;
		
	}

	/**
	 * @param statusBar
	 */
	public void setContainer(GuiContainer container) {
		this.container = container;
	}
}
