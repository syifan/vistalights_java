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
public class ViewPortCameraMouseEventHandler implements MouseEventHandler {

	protected ViewPortCamera camera;
	
	/**
	 * @param camera
	 */
	public ViewPortCameraMouseEventHandler(ViewPortCamera camera) {
		super();
		this.camera = camera;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(MouseEvent event) {
		// TODO Auto-generated method stub
		
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
		int scroll = event.getCount();
		camera.moveFar(scroll);
	}



}
