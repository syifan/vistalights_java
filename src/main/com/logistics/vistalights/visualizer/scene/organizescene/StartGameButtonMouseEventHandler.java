/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.organizescene;

import com.logistics.gamelogic.organizelogiccontroller.OrganizeLogicController;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author yifansun
 *
 */
public class StartGameButtonMouseEventHandler implements MouseEventHandler {
	
	/**
	 * Organize logic controller
	 */
	private OrganizeLogicController organizeLogicController;
	
	/**
	 * The start game button that this event handler working with
	 */
	private StartGameButton button;

	/**
	 * Constructor
	 * @param organizeLogicController
	 */
	public StartGameButtonMouseEventHandler(OrganizeLogicController 
			organizeLogicController, StartGameButton button) {
		this.organizeLogicController = organizeLogicController;
		this.button = button;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(
			com.logistics.visualizerbasic.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(com.logistics.visualizerbasic.MouseEvent event) {
		if (!button.isDisabled() && button.isMouseIn(event)) {
			this.button.disable();
			organizeLogicController.startGameWithTimer();
		}
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
