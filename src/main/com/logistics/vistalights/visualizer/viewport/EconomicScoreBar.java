/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.simulator.ScoreManager;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class EconomicScoreBar extends GuiElement {

	protected ScoreManager score;
	
	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public EconomicScoreBar(Visualizer visualizer, GuiLayer gui,
			GuiContainer parent, ScoreManager score) {
		super(visualizer, gui, parent, 
				20, 20, 100, 30);
		this.setAnchorPoint(1, 1);
		this.score = score;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiElement#render()
	 */
	public void render() {
		PGraphics canvas = this.layer.getCanvas();
		canvas.fill(255, 255, 255);
		canvas.rect((float)this.absX, (float)this.absY, 
				(float)this.width, (float)this.height);
		canvas.stroke(0, 0, 0);
		canvas.fill(0, 0, 0);
		canvas.textAlign(PConstants.LEFT, PConstants.TOP);
		canvas.text(Double.toString(score.getScore()), 
				(float) this.absX, (float)this.absY);
	}

}
