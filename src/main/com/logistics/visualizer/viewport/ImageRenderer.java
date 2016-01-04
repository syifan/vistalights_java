/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.visualizerbasic.Layer;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * @author yifansun
 *
 */
public class ImageRenderer {

	/**
	 * Image to render
	 */
	protected PImage image;
	
	/**
	 * Canvas to render on
	 */
	protected Layer layer;
	
	/**
	 * Constructor
	 * @param image
	 */
	public ImageRenderer(PImage image, Layer layer) {
		this.image = image;
		this.layer = layer;
	}
	
	/**
	 * Render the image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void render(float x, float y, float z, float width, float height) {
		PGraphics canvas = layer.getCanvas();
		canvas.noStroke();
		canvas.fill(255);
		
		canvas.beginShape(PConstants.TRIANGLE_STRIP);
		canvas.textureMode(PConstants.NORMAL);
		canvas.texture(image);
		//canvas.normal(0, 0, 1);
		canvas.vertex((float)(x - width/2), (float)(y - height/2), (float) z, 
				(float)0, (float)0);
		//canvas.normal(0, 0, 1);
		canvas.vertex((float)(x + width/2), (float)(y - height/2), (float) z, 
				(float)1, (float)0);
		//canvas.normal(0, 0, 1);
		canvas.vertex((float)(x + width/2), (float)(y + height/2), (float) z, 
				(float)1, (float)1);
		//canvas.normal(0, 0, 1);
		canvas.vertex((float)(x - width/2), (float)(y + height/2), (float) z, 
				(float)0, (float)1);
		//canvas.normal(0, 0, 1);
		canvas.vertex((float)(x - width/2), (float)(y - height/2), (float) z, 
				(float)0, (float)0);
		canvas.endShape(PConstants.CLOSE);
		
		canvas.noStroke();
		canvas.noFill();
	}
	
}
