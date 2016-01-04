/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import com.logistics.apisystem.ApiManager;
import com.logistics.simulator.SystemClock;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.scene.playscene.PlaySceneBuilder;

/**
 * @author yifansun
 *
 */
public class CountDownTimerFactory {

	private Visualizer visualizer;
	private ApiManager apiManager;

	public CountDownTimerFactory(Visualizer visualizer, ApiManager apiManager) {
		super();
		this.visualizer = visualizer;
		this.apiManager = apiManager;
	}

	/**
	 * Produce the count down timer
	 */
	CountDownTimer produceCountDownTimer() {
		PlaySceneBuilder playSceneBuilder = 
				new PlaySceneBuilder(visualizer, apiManager);
		TimeUpHandler handler = new TimeUpHandler(playSceneBuilder, visualizer);
		CountDownTimer timer = new CountDownTimer(new SystemClock(), handler);
		return timer;
	}
}
