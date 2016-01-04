/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.startscene;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizer.scene.organizescene.OrganizeSceneBuilder;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;
import com.logistics.visualizerbasic.SceneMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;
import com.logistics.visualizerbasic.gui.GuiLayerMouseEventHandler;

/**
 * @author yifansun
 *
 */
public class StartSceneBuilder extends SceneBuilder {

	private Visualizer visualizer;
	private StartScene startScene;
	private GuiLayer guiLayer;
	private StartButton startButton;

	/**
	 * @param visualizer
	 */
	public StartSceneBuilder(Visualizer visualizer) {
		super();
		this.visualizer = visualizer;
	}
	
	private void createStartScene() {
		startScene = new StartScene(visualizer);
		assignMouseEventHandlerToStartScene();
	}
	
	private void assignMouseEventHandlerToStartScene() {
		SceneMouseEventHandler sceneMouseEventHandler = 
				new SceneMouseEventHandler(startScene);
		startScene.setMouseEventHandler(sceneMouseEventHandler);
	}
	
	private void addGuiLayer() {
		guiLayer = new GuiLayer(visualizer);
		GuiLayerMouseEventHandler guiLayerMouseEventHandler = 
				new GuiLayerMouseEventHandler(guiLayer);
		guiLayer.setMouseEventHandler(guiLayerMouseEventHandler);
		startScene.addLayer(guiLayer);
	}
	
	private void addStartButton() {
		startButton = new StartButton(visualizer, guiLayer, 
				guiLayer);
		SceneBuilder orgSceneBuilder = new OrganizeSceneBuilder(visualizer);
		StartButtonMouseEventHandler startButtonMouseEventHandler = 
				new StartButtonMouseEventHandler(visualizer, orgSceneBuilder);
		startButton.setMouseEventHandler(startButtonMouseEventHandler);
		guiLayer.addSubGuiElement(startButton);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.SceneBuilder#BuildScene()
	 */
	@Override
	public Scene buildScene() {
		createStartScene();
		addGuiLayer();
		addStartButton();
		return startScene;
	}

}
