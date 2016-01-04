/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.util.Set;

import com.logistics.visualizerbasic.Layer;

/**
 * @author Yifan
 *
 */
public interface ViewPort extends Layer {

	/**
	 * @return the camera
	 */
	public abstract ViewPortCamera getCamera();

	/**
	 * @param camera the camera to set
	 */
	public abstract void setCamera(ViewPortCamera camera);

	/**
	 * Add view object
	 * @param viewObject
	 */
	public abstract void addViewObject(ViewObject viewObject);
	
	/**
	 * 
	 * @param viewObject
	 */
	public Set<ViewObject> getViewObjects();

	public abstract void removeViewObject(ViewObject viewObject);

}