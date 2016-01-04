/**
 * Logistics server side
 */
package com.logistics.visualizer;

import java.awt.Image;

import processing.core.PImage;

import com.logistics.simulator.oilspilling.OilArea;



/**
 * @author yifan
 *
 */
public class OilAreaViewObject extends VisualizerObject {
	
	/**
	 * The OilAreaObject it is showing
	 */
	OilArea oilArea;
	
	/**
	 * Constructor
	 */
	public OilAreaViewObject(OilArea oilArea)
	{
		this.oilArea = oilArea;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		double oil[][] = oilArea.getOilImage();
		for (int i = 0; i < oil.length; i++ )
		{
			for (int j = 0; j < oil[i].length; j++)
			{
				double amount = oil[i][j];
				if (amount <= 1) continue;
				
				// Get position
				double width = Terrain.width / oil.length;
				double height = Terrain.height / oil[i].length;
				double posX = width * i;
				double posY = height * j;
				
				// Put image
				int color = 255 - (int) oil[i][j];
				// int color = Math.max(0, 255 - (int) oil[i][j]);
				putColor(posX, posY, width, height, 
						visualizer.color(color, 255 - color), 1);
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#click()
	 */
	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

}
