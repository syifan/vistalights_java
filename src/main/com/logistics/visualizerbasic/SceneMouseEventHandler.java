/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

import java.util.ArrayList;

/**
 * @author yifansun
 *
 */
public class SceneMouseEventHandler implements MouseEventHandler {
	
	/**
	 * The scene it work with
	 */
	protected Scene scene;
	
	/**
	 * @param scene
	 */
	public SceneMouseEventHandler(Scene scene) {
		super();
		this.scene = scene;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	public void propagateMouseEvent(MouseEvent event) {
		ArrayList<Layer> layers = scene.getLayers();
		synchronized(layers) {
			for (Layer layer : layers) {
				layer.processMouseEvent(event);
				if (event.isStopped()) return;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mousePressed(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent event) {
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseReleased(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseDragged(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseWheel(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseWheel(MouseEvent event) {
	}

}
