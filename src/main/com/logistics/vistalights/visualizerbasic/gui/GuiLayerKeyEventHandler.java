/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import java.util.Set;

import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;

/**
 * @author yifansun
 *
 */
public class GuiLayerKeyEventHandler implements KeyEventHandler {
	
	protected GuiLayer guiLayer;
	
	/**
	 * @param guiLayer
	 */
	public GuiLayerKeyEventHandler(GuiLayer guiLayer) {
		super();
		this.guiLayer = guiLayer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void propagateKeyEvent(KeyEvent event) {
		Set<GuiElement> elements = guiLayer.getSubGuiElements();
		synchronized(elements) {
			for (GuiElement element : elements) {
				element.processKeyEvent(event);
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
