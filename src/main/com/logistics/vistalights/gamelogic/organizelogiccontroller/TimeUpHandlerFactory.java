/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.SceneBuilder;

/**
 * @author yifansun
 *
 */
public class TimeUpHandlerFactory {
	
	/**
	 * Visualizer
	 */
	Visualizer visualizer;
	
	/**
	 * The builder for play scene
	 */
	SceneBuilder playSceneBuilder;
	
	/**
	 * Constructor
	 * @param playSceneBuilder
	 * @param visualizer
	 */
	public TimeUpHandlerFactory(SceneBuilder playSceneBuilder, 
			Visualizer visualizer) {
		this.playSceneBuilder = playSceneBuilder;
		this.visualizer = visualizer;
	}

	/**
	 * Produce handler
	 * @return
	 */
	public TimeUpHandler produceTimeUpHandler()
	{
		return new TimeUpHandler(null, visualizer);
	}
}
