/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

import java.util.ArrayList;

/**
 * @author yifansun
 *
 */
public class SceneKeyEventHandler implements KeyEventHandler {
	
	/**
	 * The scene it work with
	 */
	protected Scene scene;
	
	/**
	 * @param scene
	 */
	public SceneKeyEventHandler(Scene scene) {
		super();
		this.scene = scene;
	}
	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void propagateKeyEvent(KeyEvent event) {
		ArrayList<Layer> layers = scene.getLayers();
		synchronized(layers) {
			for (Layer layer : layers) {
				layer.processKeyEvent(event);
				if (event.isStopped()) return;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyPressed(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyReleased(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyTyped(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

}
