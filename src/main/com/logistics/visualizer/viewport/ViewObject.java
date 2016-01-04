/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.shared.Point2D;
import com.logistics.shared.Point3D;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.Layer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.VisualizerObject;

/**
 * @author yifan
 *
 */
public abstract class ViewObject extends VisualizerObject {

	protected Point3D angle;
	protected Point3D position;
	protected Point3D scale;

	/**
	 * @param visualizer
	 * @param canvas
	 */
	public ViewObject(Visualizer visualizer, ViewPort viewPort) {
		super(visualizer, (Layer) viewPort);
		this.position = new Point3D(-1, -1, -1);
		this.angle = new Point3D(1, 0, 0);
		this.scale = new Point3D(1, 1, 1);
	}

	/**
	 * @return the position
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 * @return the scale
	 */
	public Point3D getScale() {
		return scale;
	}

	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.VisualizerObject#isMouseIn(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	protected boolean isMouseIn(MouseEvent event) {
		Point2D mousePos = layer.mousePosition(event);
		Point3D posToMouse = mousePos.subtract(position);
		Point3D rotatedPosToMouse = posToMouse.rotate(angle.multiply(-1));
		Point3D rotatedMousePos = position.add(rotatedPosToMouse);
		
		if (rotatedMousePos.getX() > position.getX() - scale.getX() / 2 &&
				rotatedMousePos.getX() < position.getX() + scale.getX() / 2 &&
				rotatedMousePos.getY() > position.getY() - scale.getY() / 2 &&
				rotatedMousePos.getY() < position.getY() + scale.getY() / 2) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizer.VisualizerObject#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Point3D position) {
		this.position = position;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(Point3D scale) {
		this.scale = scale;
	}

}
