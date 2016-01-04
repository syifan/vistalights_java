/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifan
 *
 */
public class SpeedSelectionButtonMouseEventHandler implements MouseEventHandler {
	
	private SpeedSelectionButton button;
	private Scheduler scheduler;
	private double timeScale;

	/**
	 * @param scheduler
	 * @param timeScale
	 */
	public SpeedSelectionButtonMouseEventHandler(SpeedSelectionButton button, 
			Scheduler scheduler,
			double timeScale) {
		super();
		this.button = button;
		this.scheduler = scheduler;
		this.timeScale = timeScale;
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
		if (button.isMouseIn(event)) {
			scheduler.setTimeScale(timeScale);
		}
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
