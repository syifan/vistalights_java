/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifansun
 *
 */
public class ViewPortMouseEventHandler implements MouseEventHandler {
	
	private ViewPort viewPort;

	/**
	 * @param viewPort
	 */
	public ViewPortMouseEventHandler(ViewPort viewPort) {
		super();
		this.viewPort = viewPort;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(MouseEvent event) {
		viewPort.getCamera().processMouseEvent(event);
		synchronized(viewPort.getViewObjects()) {
			for (ViewObject viewObject : viewPort.getViewObjects()) {
				viewObject.processMouseEvent(event);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mousePressed(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mousePressed(com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseReleased(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseReleased(com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseDragged(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseDragged(com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseWheel(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseWheel(com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
