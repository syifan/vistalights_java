/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiElement;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class SpeedController extends GuiElement implements GuiContainer {
	
	private Scheduler scheduler;
	private Set<GuiElement> elements = new HashSet<GuiElement>(4);

	/**
	 * @param visualizer
	 * @param gui
	 * @param parent
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public SpeedController(PApplet visualizer, GuiLayer gui,
			GuiContainer parent, Scheduler scheduler) {
		super(visualizer, gui, parent, 0, 0, 90, 90);
		this.scheduler = scheduler;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiElement#render()
	 */
	@Override
	public void render() {
		PGraphics canvas = layer.getCanvas();
		
		// Draw the clock circle
		canvas.fill(36, 55, 78);
		canvas.stroke(183, 183, 183);
		canvas.strokeWeight(2);
		canvas.ellipseMode(PConstants.CORNER);
		canvas.ellipse((float) absX+2, (float) (absY + 10), 
				(float)80, (float)80);
		
		// Get time
		LocalDateTime time = scheduler.getVirtualTime();
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		// Draw the minute hand
		canvas.fill(237, 28, 36);
		canvas.noStroke();
		double minuteHandAngle = (minute + second / 60.0) * (Math.PI / 30);
		canvas.pushMatrix();
		canvas.translate((float) absX + 2 + 40, (float) absY + 10 + 40);
		canvas.rotate((float) minuteHandAngle);
		canvas.rect(-2, -30, 4, 30);
		canvas.popMatrix();
		
		// Draw the hour hand
		double hourHandAngle = (hour + (minute / 60.0)) * (Math.PI / 6);
		canvas.noStroke();
		canvas.fill(255);
		canvas.pushMatrix();
		canvas.translate((float) absX + 2 + 40, (float) absY + 10 + 40);
		canvas.rotate((float) hourHandAngle);
		canvas.rect(-3, -25, 6, 25);
		canvas.popMatrix();
		
		// Draw center circles
		canvas.fill(255);
		canvas.ellipseMode(PConstants.CENTER);
		canvas.ellipse((float) absX + 2 + 40, (float) absY + 10 + 40, 
				(float)12, (float)12);
		
		canvas.fill(35, 31, 32);
		canvas.ellipseMode(PConstants.CENTER);
		canvas.ellipse((float) absX + 2 + 40, (float) absY + 10 + 40, 
				(float)3, (float)3);
		
		// Render four speed selection buttons
		for (GuiElement element : elements) {
			element.render();
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getX()
	 */
	@Override
	public double getX() {
		return absX;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getY()
	 */
	@Override
	public double getY() {
		return absY;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getWidth()
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getHeight()
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#addSubGuiElement(com.logistics.visualizerbasic.gui.GuiElement)
	 */
	@Override
	public void addSubGuiElement(GuiElement guiElement) {
		this.elements.add(guiElement);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.gui.GuiContainer#getSubGuiElements()
	 */
	@Override
	public Set<GuiElement> getSubGuiElements() {
		return elements;
	}

}
