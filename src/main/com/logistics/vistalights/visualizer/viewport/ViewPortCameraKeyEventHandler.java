/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.awt.event.KeyEvent;

import com.logistics.visualizerbasic.KeyEventHandler;

/**
 * @author yifansun
 *
 */
public class ViewPortCameraKeyEventHandler implements
		KeyEventHandler {
	
	protected ViewPortCamera camera;

	/**
	 * @param camera
	 */
	public ViewPortCameraKeyEventHandler(ViewPortCamera camera) {
		super();
		this.camera = camera;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyPressed(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyPressed(com.logistics.visualizerbasic.KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_W) {
			camera.moveUp();
		}
		if (event.getKeyCode() == KeyEvent.VK_A) {
			camera.moveLeft();
		}
		if (event.getKeyCode() == KeyEvent.VK_S) {
			camera.moveDown();
		}
		if (event.getKeyCode() == KeyEvent.VK_D) {
			camera.moveRight();
		}
		if (event.getKeyCode() == KeyEvent.VK_Z) {
			camera.moveFar(1);
		}
		if (event.getKeyCode() == KeyEvent.VK_X) {
			camera.moveFar(-1);
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyReleased(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyReleased(com.logistics.visualizerbasic.KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyTyped(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyTyped(com.logistics.visualizerbasic.KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

}
