/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.simulator.ScoreManager;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifan
 *
 */
public class BudgetScoreMonitor extends GuiElement {
	
	private ScoreManager score;

	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public BudgetScoreMonitor(PApplet visualizer, GuiLayer gui,
			GuiContainer parent, ScoreManager score) {
		super(visualizer, gui, parent, 200, 10, 200, 30);
		this.setAnchorPoint(1, 3);
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.Renderable#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		
		canvas.fill(255);
		canvas.stroke(255);
		canvas.textAlign(PConstants.LEFT);
		canvas.text("Budget: $" + String.format("%1$,.2f", score.getScore()), 
				(float) this.absX, (float)this.absY, 
				(float)this.width, (float)this.height/2);

	}

}
