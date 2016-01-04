/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import com.logistics.apisystem.ApiManager;
import com.logistics.apisystem.ApiManagerImpl;
import com.logistics.visualizer.Visualizer;

/**
 * @author yifansun
 *
 */
public class OrganizeLogicControllerFactory {
	
	/**
	 * The visualizer dependency
	 */
	private Visualizer visualizer;

	/**
	 * @param visualizer
	 */
	public OrganizeLogicControllerFactory(Visualizer visualizer) {
		super();
		this.visualizer = visualizer;
	}

	public OrganizeLogicController produceOrganizeLogicController() {
		// Init api manager
		ApiManagerImpl apiManager = new ApiManagerImpl();
		new Thread(apiManager).start();
		
		// Create organize logic controller
		OrganizeLogicController controller = new OrganizeLogicController();
		
		// Add controller to api manager subscriber list
		apiManager.addUserInfoSubscriber(controller);
		
		// Create count down timer
		CountDownTimerFactory countDownTimerFactory = 
				new CountDownTimerFactory(visualizer, apiManager);
		CountDownTimer countDownTimer = 
				countDownTimerFactory.produceCountDownTimer();
		controller.setCountDownTimer(countDownTimer);

		// Return controller
		return controller;
	}
}
