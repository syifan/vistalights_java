/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.organizescene;

import com.logistics.gamelogic.organizelogiccontroller.OrganizeLogicController;
import com.logistics.gamelogic.organizelogiccontroller.OrganizeLogicControllerFactory;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;
import com.logistics.visualizerbasic.SceneMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;
import com.logistics.visualizerbasic.gui.GuiLayerMouseEventHandler;

/**
 * @author yifansun
 *
 */
public class OrganizeSceneBuilder extends SceneBuilder {

	private Visualizer visualizer;
	private OrganizeScene scene;
	private GuiLayer guiLayer;
	private OrganizeLogicController controller;
	private StartGameButton button;
	
	private void createOrganizeScene() {
		scene =  new OrganizeScene(visualizer);
		addMouseEventHandlerToScene();
		createOrganizeSceneController();
	}
	
	private void addMouseEventHandlerToScene() {
		SceneMouseEventHandler sceneMouseEventHandler = 
				new SceneMouseEventHandler(scene);
		scene.setMouseEventHandler(sceneMouseEventHandler);
	}
	
	private void addGuiLayer() {
		guiLayer = new GuiLayer(visualizer);
		GuiLayerMouseEventHandler guiLayerMouseEventHandler = 
				new GuiLayerMouseEventHandler(guiLayer);
		guiLayer.setMouseEventHandler(guiLayerMouseEventHandler);
		scene.addLayer(guiLayer);
	}
	
	private void createOrganizeSceneController() {
		OrganizeLogicControllerFactory controllerFactory = new
				OrganizeLogicControllerFactory(visualizer);
		controller = controllerFactory.
				produceOrganizeLogicController();
	}
	
	private void addGuiElements() {
		addStartGameButton(); 
	}
	
	private void addStartGameButton() {
		StartGameButtonFactory buttonFactory = new StartGameButtonFactory(
				visualizer, guiLayer, guiLayer, controller);
		button = buttonFactory.produceStartGameButton();
		guiLayer.addSubGuiElement(button);
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.visualizer.scene.SceneBuilder#BuildScene()
	 */
	@Override
	public Scene buildScene() {
		createOrganizeScene();
		addGuiLayer();
		addGuiElements();
		return scene;
	}

	public OrganizeSceneBuilder(Visualizer visualizer) {
		super();
		this.visualizer = visualizer;
	}


}
