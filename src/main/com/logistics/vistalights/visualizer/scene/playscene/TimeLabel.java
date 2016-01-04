/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import java.time.format.DateTimeFormatter;

import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PGraphics;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class TimeLabel extends GuiElement {
	
	private Scheduler scheduler;
	private PFont font;

	/**
	 * @param visualizer
	 * @param canvas
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TimeLabel(Visualizer visualizer, GuiLayer guiLayer,
			GuiContainer parent, Scheduler scheduler) {
		super(visualizer, guiLayer, parent, 100, 10, 80, 30);
		this.setAnchorPoint(1, 3);
		this.scheduler = scheduler;
		font = visualizer.createFont("Arial Bold", 12);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		
		// Format time
		canvas.fill(255);
		canvas.textFont(font);
		//canvas.textSize(12);
		canvas.textAlign(PConstants.CENTER, PConstants.CENTER);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(
				"MM/dd/yyyy");;
		String dateString = scheduler.getVirtualTime().format(dateFormatter);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(
				"hh:mm:ss a");;
		String timeString = scheduler.getVirtualTime().format(timeFormatter);
		canvas.text(timeString, (float)absX, (float)absY, 
				(float)width, (float) (height / 2));
		canvas.text(dateString, (float)absX, (float) (absY + height / 2), 
				(float)width, (float) (height / 2));
	}

}
