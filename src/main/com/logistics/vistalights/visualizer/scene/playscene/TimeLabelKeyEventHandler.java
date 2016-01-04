/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;

/**
 * @author yifansun
 *
 */
public class TimeLabelKeyEventHandler implements KeyEventHandler {
	
	protected Scheduler scheduler;

	/**
	 * @param scheduler
	 */
	public TimeLabelKeyEventHandler(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#propagateKeyEvent(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void propagateKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.KeyEventHandler#keyPressed(com.logistics.visualizerbasic.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
			scheduler.setTimeScale(1);
		}
		if (event.getKeyCode() == java.awt.event.KeyEvent.VK_1) {
			scheduler.setTimeScale(100);
		}
		if (event.getKeyCode() == java.awt.event.KeyEvent.VK_2) {
			scheduler.setTimeScale(300);
		}
		if (event.getKeyCode() == java.awt.event.KeyEvent.VK_3) {
			scheduler.setTimeScale(700);
		}
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
