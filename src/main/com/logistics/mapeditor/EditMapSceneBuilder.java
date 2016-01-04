/**
 * Logistics server side
 */
package com.logistics.mapeditor;

import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;
import com.logistics.visualizerbasic.SceneMouseEventHandler;
import com.logistics.visualizerbasic.gui.GuiLayer;
import com.logistics.visualizerbasic.gui.GuiLayerMouseEventHandler;

/**
 * @author yifan
 *
 */
public class EditMapSceneBuilder extends SceneBuilder {

	protected MapEditor mapEditor;

	/**
	 * @param mapEditor
	 */
	public EditMapSceneBuilder(MapEditor mapEditor) {
		super();
		this.mapEditor = mapEditor;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.SceneBuilder#buildScene()
	 */
	@Override
	public Scene buildScene() {
		Scene editMapScene = new EditMapScene(mapEditor);
		SceneMouseEventHandler sceneMouseEventHandler = 
				new SceneMouseEventHandler(editMapScene);
		editMapScene.setMouseEventHandler(sceneMouseEventHandler);
		
		// Create gui layer
		GuiLayer guiLayer = new GuiLayer(mapEditor);
		GuiLayerMouseEventHandler guiLayerMouseEventHandler = 
				new GuiLayerMouseEventHandler(guiLayer);
		guiLayer.setMouseEventHandler(guiLayerMouseEventHandler);
		editMapScene.addLayer(guiLayer);
		
		// Create button
		CreateRoadButton button = new CreateRoadButton(mapEditor, guiLayer, guiLayer);
		CreateRoadButtonMouseEventHandler createRoadButtonMouseEventHandler = 
				new CreateRoadButtonMouseEventHandler(button);
		button.setMouseEventHandler(createRoadButtonMouseEventHandler);
		guiLayer.addSubGuiElement(button);
		
		return editMapScene;
	}

}
