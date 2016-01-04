/**
 * Logistics server side
 */
package com.logistics.simulator.oilspilling;

import java.util.ArrayList;

import com.logistics.shared.Point3D;
import com.logistics.simulator.scheduler.SchedulerImpl;
import com.logistics.visualizer.Visualizer;

import processing.core.PImage;

/**
 * @author yifan
 *
 */
public class OilArea {
	
	/**
	 * A black and white image that masks water with black color
	 */
	protected PImage waterMask = null;
	
	/**
	 * A grey scale image that show how much oil each pixel has
	 */
	protected double oilMask[][] = null;
	protected double tempOil[][] = null;
	
	/**
	 * 
	 */
	protected int oilMinX = -1;
	protected int oilMinY = -1;
	protected int oilMaxX = -2;
	protected int oilMaxY = -2;
	
	ArrayList<OilLeakSource> leakSources = new ArrayList<OilLeakSource>();
	
	/**
	 * Spread rate
	 */
	double halfLife = 10 * 60;
	
	/**
	 * Convert a position to index on X axis
	 */
	protected int positionXToIndex(double posX) {
		return (int) ((waterMask.width / 100000) * posX);
	}
	
	/**
	 * Convert a position to index on Y axis
	 */
	protected int positionYToIndex(double posY) {
		return (int) ((waterMask.height / 100000) * posY);
	}
	
	/**
	 * Get the image represent the oil spilling
	 * @return
	 */
	public double[][] getOilImage()
	{
		return oilMask;
	}
	
	/**
	 * Constructor
	 */
	public OilArea()
	{
		/*
		waterMask = Visualizer.getInstance().loadImage(
				"maps/map(0,0)/water_mask_min_min.png");
		oilMask = new double[waterMask.width][waterMask.height];
		tempOil = new double[waterMask.width][waterMask.height];
		*/
	}

	/**
	 * Get the amount of oil in a certain position
	 * @param position
	 * @return
	 */
	public double getOilAmount(Point3D position) {
		// Convert coordination
		int indexX = positionXToIndex(position.getX());
		int indexY = positionYToIndex(position.getY());
		
		// Get color
		double c = oilMask[indexX][indexY];
		return c;
	}

	/**
	 * @param amountToLeak
	 */
	public void inject(Point3D position, double amountToLeak) {
		// Convert coordination
		int indexX = positionXToIndex(position.getX());
		int indexY = positionYToIndex(position.getY());
		
		// Update color
		double c = oilMask[indexX][indexY];
		c += amountToLeak;
		oilMask[indexX][indexY] = c;
	}
	
	/**
	 * 
	 */
	public void startToLeak(OilLeakSource source)
	{
		// Add to list
		this.leakSources.add(source);
		
		// Convert coordination
		Point3D position = source.getPosition();
		int indexX = positionXToIndex(position.getX());
		int indexY = positionYToIndex(position.getY());
		
		// First
		if (oilMinX < 0) 
		{
			oilMinX = indexX;
			oilMinY = indexY;
			oilMaxX = indexX;
			oilMaxY = indexY;
		}
	}
	
	/**
	 * Spread
	 */
	public void Spread(double timeElapsed) 
	{
		this.tempOil = new double[waterMask.width][waterMask.height];
		
		for (int i = oilMinX; i <= oilMaxX; i++) {
			for (int j = oilMinY; j <= oilMaxY; j++) {
				if (!isWater(i, j)) continue;
				//if (oilMask[i][j] <= 100) continue;
				
				// Amount to flow
				double flowLeft = 0;
				double flowTop = 0;
				double flowRight = 0;
				double flowBottom = 0;
				double fromAmount = oilMask[i][j];
				
				if (i != 0) {
					double toAmount = oilMask[i-1][j];
					flowLeft = this.getSpreadAmount(fromAmount, 
							toAmount, timeElapsed);	
				}
				if (j != 0) {
					double toAmount = oilMask[i][j-1];
					flowTop = this.getSpreadAmount(fromAmount, toAmount, 
							timeElapsed);
				}
				if (i != oilMask.length - 1) {
					double toAmount = oilMask[i+1][j];
					flowRight = this.getSpreadAmount(fromAmount, toAmount, 
							timeElapsed);
				}
				if (j != oilMask[i].length-1) {
					double toAmount = oilMask[i][j+1];
					flowBottom = this.getSpreadAmount(fromAmount, toAmount, 
							timeElapsed);
				}
				
				// 
				if (flowLeft + flowTop + flowRight + flowBottom > fromAmount) {
					System.out.format("No enough amount to flow\n");
				}
				
				// Spread
				if (i != 0) {
					SpreadTo(i, j, i-1, j, flowLeft);
				}
				if (j != 0) {
					SpreadTo(i, j, i, j-1, flowTop);
				}
				if (i != oilMask.length - 1) {
					SpreadTo(i, j, i+1, j, flowRight);
				}
				if (j != oilMask[i].length-1) {
					SpreadTo(i, j, i, j + 1, flowBottom);
				}
			}
		}
			
		// Accumulate
		for (int i = oilMinX; i <= oilMaxX; i++) {
			for (int j = oilMinY; j <= oilMaxY; j++) {
				oilMask[i][j] += tempOil[i][j];
			}
		}
		
	}
	
	/**
	 * Check if a tile is water
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean isWater(int x, int y){
		int c = this.waterMask.get(x, y);
		if (c != 0)
		{
			return true;
		}
		return false;
	}
	
	
	protected double getSpreadAmount(double fromAmount, double toAmount, 
			double timeElapsed)
	{
		if (fromAmount <= toAmount) return 0;
		double remainAmount = (fromAmount - toAmount) * Math.pow(0.5, 
				(timeElapsed / halfLife));
		double flow = (fromAmount - toAmount) - remainAmount;
		return flow;
	}
	
	
	protected void SpreadTo(int fromX, int fromY, int toX, int toY, 
			double amount) {
		
		if (!isWater(toX, toY)) return;

		if (amount > 1e-10) {
			if(oilMinX > toX) oilMinX = toX;
			if(oilMaxX < toX) oilMaxX = toX;
			if(oilMinY > toY) oilMinY = toY;
			if(oilMaxY < toY) oilMaxY = toY;
		}
		
		tempOil[fromX][fromY] -= amount;
		tempOil[toX][toY] += amount;
	}
	
	public void tick() {
		// Iterations
		double timeElapsed = SchedulerImpl.getInstance().getVirtualTimeElapsed();
		int numIter = (int) (timeElapsed / this.halfLife * 4) + 1;
		
		// Spread for a few times
		for (int i = 0; i < numIter; i++) {
			for (OilLeakSource source : this.leakSources) {
				source.Leak(timeElapsed);
			}
			this.Spread(timeElapsed / numIter);
		}
	}
	
}
