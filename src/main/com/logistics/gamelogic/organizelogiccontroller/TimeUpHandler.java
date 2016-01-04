/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import com.logistics.gamelogic.EventHandler;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;

/**
 * @author yifansun
 *
 */
public class TimeUpHandler implements EventHandler {
	
	/**
	 * The scene builder
	 */
	SceneBuilder playSceneBuilder;
	
	/**
	 * Visualizer
	 */
	Visualizer visualizer;
	
	/**
	 * Constructor
	 * @param playSceneBuilder
	 * @param visualizer
	 */
	public TimeUpHandler(SceneBuilder playSceneBuilder, Visualizer visualizer) {
		super();
		this.playSceneBuilder = playSceneBuilder;
		this.visualizer = visualizer;
	}

	/* (non-Javadoc)
	 * @see com.logistics.gamelogic.EventHandler#process()
	 */
	@Override
	public void process() {
		Scene playScene = playSceneBuilder.buildScene();
		visualizer.changeScene("PlayScene", playScene);
	}

}
