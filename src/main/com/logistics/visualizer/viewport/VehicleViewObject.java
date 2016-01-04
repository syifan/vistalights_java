/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import com.logistics.shared.Point3D;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifan
 *
 */
public class VehicleViewObject extends ViewObject 
	implements CameraPositionSubscriber {

	private Vehicle vehicle;
	
	protected PImage image;
	
	protected ImageRenderer imageRenderer;
	
	protected ImageRenderer symbolRenderer;
	
	protected boolean isSelected;

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public VehicleViewObject(Visualizer visualizer, ViewPort viewPort, 
			Vehicle vehicle) {
		super(visualizer, viewPort);
		
		this.vehicle = vehicle;
		image = visualizer.loadImage("assets/ship_bulk.png");
		imageRenderer = new ImageRenderer(image, layer);
		
		// Load symbols
		PImage symbol = null;
		switch(vehicle.getIndustryType()) {
		case PETRO:
			symbol = visualizer.loadImage("assets/industry_symbol/petro.png");
			break;
		case BREAKBULK:
			symbol = visualizer.loadImage("assets/industry_symbol/breakbulk.png");
			break;
		case BULK:
			symbol = visualizer.loadImage("assets/industry_symbol/bulk.png");
			break;
		default:
			break;
		}
		if (symbol != null) {
			symbolRenderer = new ImageRenderer(symbol, layer);
		}
		
		
		// Give an init value of position, angle and scale.
		this.position = vehicle.getPosition();
		this.updateCameraPosition(viewPort.getCamera().getPosition());
		this.angle = vehicle.getHeading();
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		
		// Get canvas
		PGraphics canvas = layer.getCanvas();
		
		// Set the position and angle
		this.position = vehicle.getPosition();
		
		// Set the angle
		double headingX = vehicle.getHeading().getX();
		double headingY = -vehicle.getHeading().getY();
		if(Math.abs(headingY) < 1e-6) {
			headingY += 0.5e-6;
		}
		double rotateZ = Math.atan(headingX / headingY);
		if (headingY < 0)
		{
			rotateZ += Math.PI;
		}
		this.angle = new Point3D(0, 0, rotateZ);
		
		// Store the current matrix setting
		canvas.pushMatrix();
		
		// Translate the vehicle to its position
		canvas.translate((float) this.position.getX(), 
				(float) this.position.getY());
		
		// Rotate the vehicle
		canvas.rotateZ((float) rotateZ);
		
		// Put the image
		imageRenderer.render(
				0, 0, 50,
				(float)this.scale.getX(), 
				(float)this.scale.getY());
		
		// System.out.format("Current tonnage %f\n", vehicle.getCargoContainer().getTonnage());
		if (symbolRenderer != null) {
			symbolRenderer.render(0, 0, 100, 
					(float) (this.scale.getX() * vehicle.getCargoContainer().getTonnage() / 5000),
					(float) (this.scale.getX() * vehicle.getCargoContainer().getTonnage() / 5000));
		}
		
		// Selected effect
		if (isSelected) {
			canvas.rectMode(PConstants.CENTER);
			canvas.noFill();
			canvas.stroke(255, 0, 0);
			canvas.rect(0, 0, 
					(float) this.scale.getX() * 2, 
					(float) this.scale.getY() * 2);
		}

		// Restore the matrix
		canvas.popMatrix();
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.playscene.CameraPositionSubscriber#updateCameraPosition(com.logistics.shared.Point3D)
	 */
	@Override
	public void updateCameraPosition(Point3D position) {
		double cameraHeight = position.getZ();
		
		// Calculated scaled length
		this.scale.setX(cameraHeight * vehicle.getSize().getX() / 3e3);
		if (scale.getX() < vehicle.getSize().getX()) {
			scale.setX(vehicle.getSize().getX());
		}
		
		// Calculated scaled height
		this.scale.setY(cameraHeight * vehicle.getSize().getY() / 3e3);
		if (scale.getY() < vehicle.getSize().getY()) {
			scale.setY(vehicle.getSize().getY());
		}
		
	}

}
