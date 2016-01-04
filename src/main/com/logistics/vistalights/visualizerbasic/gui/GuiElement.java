/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import processing.core.PApplet;

import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.VisualizerObject;

/**
 * A GuiElement is an element that can be 
 * @author yifan
 *
 */
public abstract class GuiElement extends VisualizerObject {
	/**
	 * The parent element
	 */
	protected GuiContainer parent;
	
	/**
	 * Position of x axis relative to the anchor point
	 */
	protected double x;
	
	/**
	 * Position of the y axis relative to the anchor point
	 */
	protected double y;
	
	/**
	 * The absolute position in x axis
	 */
	protected double absX;
	
	/**
	 * The absolute position in y axis
	 */
	protected double absY;
	
	/**
	 * Width of the element in pixel
	 */
	protected double width;
	
	/**
	 * Height of the element in pixel
	 */
	protected double height;
	
	/**
	 * The anchor point on the X axis
	 */
	protected int anchorX = 1;
	
	/**
	 * The anchor point on the Y axis
	 */
	protected int anchorY = 1;

	/**
	 * Constructor
	 */
	public GuiElement(PApplet visualizer, GuiLayer gui,
			GuiContainer parent, double x, double y, 
			double width, double height) {
		super(visualizer, gui);
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setAnchorPoint(1, 1);
	}
	
	/**
	 * Set the reference point that this gui element is positioning at
	 * @param anchorX 1 - left, 2 - center, 3 - right
	 * @param anchorY 1 - top, 2 - middle, 3 - bottom
	 */
	public void setAnchorPoint(int anchorX, int anchorY){
		// Only allow anchor point to be 1, 2 or 3
		assert(anchorX == 1 || anchorX == 2 || anchorX == 3);
		assert(anchorY == 1 || anchorY == 2 || anchorY == 3);
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		
		// Set absolute position on X axis
		switch (anchorX) {
		case 1:
			this.absX = this.x + this.parent.getX(); 
			break;
		case 2:
			this.absX = this.x + this.parent.getX() + 
				this.parent.getWidth() / 2 - this.width / 2;
			break;
		case 3:
			this.absX = this.parent.getX() + 
				this.parent.getWidth() - this.width - this.x;
			break;
		default:
			break;
		}
		
		// Set absolute position on Y axis
		switch (anchorY) {
		case 1:
			this.absY = this.y + this.parent.getY(); 
			break;
		case 2:
			this.absY = this.y + this.parent.getY() + 
				this.parent.getHeight() / 2 - this.height / 2;
			break;
		case 3:
			this.absY = this.parent.getY() + 
				this.parent.getHeight() - this.height - this.y;
			break;
		default:
			break;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#isMouseIn()
	 */
	public boolean isMouseIn(MouseEvent event) {
		if (event.getX() > absX && 
				event.getX() < absX + width && 
				event.getY() > absY && 
				event.getY() < absY + height)
		{
			return true;
		}
		return false;
	}
}
