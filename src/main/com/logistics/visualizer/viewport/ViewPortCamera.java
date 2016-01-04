/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.util.ArrayList;

import com.logistics.shared.Point3D;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.VisualizerObject;

import processing.core.PConstants;
import processing.core.PGraphics;

/**
 * @author yifansun
 *
 */
public class ViewPortCamera extends VisualizerObject {
	
	/**
	 * Coordination of the camera
	 */
	protected Point3D position = new Point3D(20000, 50000, 30000);
	
	/**
	 * The width and height that is going to allow the camera to show 
	 */
	protected double mapWidth = 100000;
	protected double mapHeight = 100000;
	
	/**
	 * The increment to the camera's coordinate
	 */
	protected double moveSpeed = 0.02;
	
	/**
	 * The minimum height that a camera is allowed to move to 
	 */
	protected double minHeight = 1000;
	
	/**
	 * The maximum height that detailed map should be used
	 */
	protected double maxDetailMapHeight = 0;
	
	/**
	 * A list of camera position subscribers
	 */
	ArrayList<CameraPositionSubscriber> positionSubscribers = 
			new ArrayList<CameraPositionSubscriber>();
	
	/**
	 * @return the maxDetailMapHeight
	 */
	public double getMaxDetailMapHeight() {
		return maxDetailMapHeight;
	}

	/**
	 * @param maxDetailMapHeight the maxDetailMapHeight to set
	 */
	public void setMaxDetailMapHeight(double maxDetailMapHeight) {
		this.maxDetailMapHeight = maxDetailMapHeight;
	}

	/**
	 * The maximum height that a camera can achieve
	 */
	protected double maxHeight = 5e4;
	
	/**
	 * The distance to mouse plain
	 */
	protected double distMousePlain = 0;
	
	/**
	 * @return the distMousePlain
	 */
	public double getDistMousePlain() {
		return distMousePlain;
	}

	/**
	 * @return the margin_left
	 */
	public double getMarginLeft() {
		return marginLeft;
	}

	/**
	 * @param margin_left the margin_left to set
	 */
	public void setMarginLeft(double margin_left) {
		this.marginLeft = margin_left;
	}

	/**
	 * @return the margin_right
	 */
	public double getMarginRight() {
		return marginRight;
	}

	/**
	 * @param margin_right the margin_right to set
	 */
	public void setMarginRight(double margin_right) {
		this.marginRight = margin_right;
	}

	/**
	 * @return the margin_top
	 */
	public double getMarginTop() {
		return marginTop;
	}

	/**
	 * @param margin_top the margin_top to set
	 */
	public void setMarginTop(double margin_top) {
		this.marginTop = margin_top;
	}

	/**
	 * @return the margin_bottom
	 */
	public double getMarginBottom() {
		return marginBotton;
	}

	/**
	 * @param margin_bottom the margin_bottom to set
	 */
	public void setMarginBottom(double margin_bottom) {
		this.marginBotton = margin_bottom;
	}

	/**
	 * The x coordinate where the left most point in the view point is on 
	 * the map plain
	 */
	protected double marginLeft = 0;
	
	/**
	 * The x coordinate where the right most point in the view point is on 
	 * the map plain
	 */
	protected double marginRight = 0;
	
	/**
	 * The y coordinate where the top most point in the view point is on 
	 * the map plain
	 */
	protected double marginTop = 0;
	
	/**
	 * The y coordinate where the bottom most point in the view point is on 
	 * the map plain
	 */
	protected double marginBotton = 0;
	
	/**
	 * Constructor
	 */
	public ViewPortCamera(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, viewPort);
		
		// Get canvas
		PGraphics canvas = layer.getCanvas();
		
		// Update margin information
		this.updateMargins();
		
		// Calculate max height
		this.maxHeight = (mapWidth / canvas.width ) * distMousePlain;
		
		// Calculate min height
		double span = canvas.width / 8192.0 * mapWidth;
		this.minHeight = (span / canvas.width) * distMousePlain;
		
		// The height when detailed map is needed
		double span_min = canvas.width / 2000.0 * mapWidth;
		this.maxDetailMapHeight = (span_min / canvas.width) * distMousePlain;
		
		// Init value
		this.position.setZ(this.minHeight);
	}
	
	/**
	 * Render the camera
	 */
	public void render() {
		// Get canvas
		PGraphics canvas = layer.getCanvas();
		
		// Set light
		canvas.lights();
		
		// Place camera
		canvas.camera((float)position.getX(), 
				(float)position.getY(), 
				(float)position.getZ(), 
				(float)position.getX(), 
				(float)position.getY(), 
				(float)0, 
				(float)0.0, (float)1.0, (float)0.0);
		canvas.perspective((float)(PConstants.PI/3.0), 
				(float)canvas.width/canvas.height, 1, 1000000);
	}

	/**
	 * Return the position of the camera
	 * @return
	 */
	public Point3D getPosition() {
		return position;
	}

	public void moveUp(){
		position.setY(position.getY() - moveSpeed * position.getZ());
		updateMargins();
		if (this.isOutOfMargin()) {
			position.setY(position.getY() + moveSpeed * position.getZ());
			updateMargins();
		}
		NotifyPositionSubscribers();
	}
	
	public void moveDown(){
		position.setY(position.getY() + moveSpeed * position.getZ());
		updateMargins();
		if (this.isOutOfMargin()) {
			position.setY(position.getY() - moveSpeed *position.getZ());
			updateMargins();
		}
		NotifyPositionSubscribers();
	}
	
	public void moveLeft(){
		position.setX(position.getX() - moveSpeed *position.getZ());
		updateMargins();
		if (this.isOutOfMargin()) {
			position.setX(position.getX() + moveSpeed *position.getZ());
			updateMargins();
		}
		NotifyPositionSubscribers();
	}
	
	public void moveRight(){
		position.setX(position.getX() + moveSpeed *position.getZ());
		updateMargins();
		if (this.isOutOfMargin()) {
			position.setX(position.getX() - moveSpeed *position.getZ());
			updateMargins();
		}
		NotifyPositionSubscribers();
	}
	
	public void moveFar(int amount){
		position.setZ(position.getZ() + amount * 2 * (moveSpeed * position.getZ()));
		if (position.getZ() < this.minHeight){
			position.setZ(this.minHeight);
		}else if(position.getZ() > this.maxHeight){
			position.setZ(this.maxHeight);
		}
		updateMargins();
		if (isOutOfMargin()) {
			moveToFit();
			updateMargins();
		}
		NotifyPositionSubscribers();
	}
	
	/**
	 * Update the margin information
	 * @return
	 */
	protected void updateMargins() {
		// Get canvas
		PGraphics canvas = layer.getCanvas();
		
		// Get Distance to mouse play
		this.distMousePlain = (canvas.height / 2) / Math.tan(Math.PI/6.0);
		
		// Check left margin
		this.marginLeft = position.getX() - (position.getZ() / distMousePlain) * (canvas.width / 2);
		
		// Check right margin
		this.marginRight = position.getX() + (position.getZ() / distMousePlain) * (canvas.width / 2);
		
		// Check top margin
		this.marginTop = position.getY() - (position.getZ() / distMousePlain) * (canvas.height / 2);
		
		// Check bottom margin
		this.marginBotton = position.getY() + (position.getZ() / distMousePlain) * (canvas.height / 2);
	}
	
	/**
	 *  Checks if the viewport is out of the map margin
	 * @return
	 */
	public boolean isOutOfMargin() {
		
		// Check left margin
		if (this.marginLeft < 0) return true;
		
		// Check right margin
		if (this.marginRight > mapWidth) return true;
		
		// Check top margin
		if (this.marginTop < 0) return true;
		
		// Check bottom margin
		if (this.marginBotton > mapHeight) return true;
		
		// All criterion met
		return false;
	}
	
	// When zoom out, the view port can be out of the mat margin. This function
	// moves the camera so that the camera align with the map
	public void moveToFit()
	{
		// Get canvas
		PGraphics canvas = layer.getCanvas();
		
		// Get distance to the mouse plain
		double distanceMousePlain = (canvas.height / 2) / Math.tan(Math.PI/6.0);
		
		// Check left margin
		double left = position.getX() - (position.getZ() / distanceMousePlain) * (canvas.width / 2);
		if (left < 0)
		{
			position.setX((position.getZ() / distanceMousePlain) * (canvas.width / 2));
		}
		
		// Check right margin
		double right = position.getX() + (position.getZ() / distanceMousePlain) * (canvas.width / 2);
		if (right > mapWidth)
		{
			position.setX(mapWidth - (position.getZ() / distanceMousePlain) * (canvas.width / 2));
		}
		
		// Check top margin
		double top = position.getY() - (position.getZ() / distanceMousePlain) * (canvas.height / 2);
		if (top < 0) 
		{
			position.setY((position.getZ() / distanceMousePlain) * (canvas.height / 2));
		}
		
		// Check bottom margin
		double bottom = position.getY() + (position.getZ() / distanceMousePlain) * (canvas.height / 2);
		if (bottom > mapHeight)
		{
			position.setY(mapHeight - (position.getZ() / distanceMousePlain) * (canvas.height / 2));
		}
		
		// Update margins
		updateMargins();
	}
	
	/**
	 * Notify camera position subscribers about the position change
	 */
	protected void NotifyPositionSubscribers() {
		for (CameraPositionSubscriber subscriber : positionSubscribers) {
			subscriber.updateCameraPosition(position);
		}
	}
	
	/**
	 * Add an subscriber to the subscriber list
	 * @param subscriber
	 */
	public void addPositionSubscriber(CameraPositionSubscriber subscriber) {
		this.positionSubscribers.add(subscriber);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.VisualizerObject#isMouseIn()
	 */
	@Override
	protected boolean isMouseIn(MouseEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
