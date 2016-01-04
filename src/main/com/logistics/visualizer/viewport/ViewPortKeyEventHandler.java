/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import java.util.ArrayList;

import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;
import com.logistics.visualizerbasic.VisualizerObject;

/**
 * @author yifansun
 *
 */
public class ViewPortKeyEventHandler implements KeyEventHandler {

	ViewPort viewPort;

	/**
	 * @param viewObjects
	 */
	public ViewPortKeyEventHandler(ViewPort viewPort) {
		super();
		this.viewPort = viewPort;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void propagateKeyEvent(KeyEvent event) {
		viewPort.getCamera().processKeyEvent(event);
		synchronized(viewPort.getViewObjects()) {
			for (VisualizerObject viewObject : viewPort.getViewObjects()) {
				viewObject.processKeyEvent(event);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyPressed(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		
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
