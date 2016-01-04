/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import java.util.Set;

import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifansun
 *
 */
public class GuiLayerMouseEventHandler implements MouseEventHandler {
	
	/**
	 * Gui Layer that this mouse event handler serve
	 */
	protected GuiLayer guiLayer;
	
	/**
	 * @param guiLayer
	 */
	public GuiLayerMouseEventHandler(GuiLayer guiLayer) {
		super();
		this.guiLayer = guiLayer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(MouseEvent event) {
		Set<GuiElement> elements = guiLayer.getSubGuiElements();
		synchronized(elements) {
			for (GuiElement element : elements) {
				element.processMouseEvent(event);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mousePressed(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseReleased(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseDragged(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseWheel(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseWheel(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
