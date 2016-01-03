package com.logistics.vistalights.startscene;

import com.logistics.pvis.dimension.Dimension;
import com.logistics.pvis.frame.ProcessingFrame;
import com.logistics.pvis.gui.anchorpoint.AnchorPoint;
import com.logistics.pvis.gui.guielement.button.Button;
import com.logistics.pvis.gui.guielement.button.ButtonFactory;
import com.logistics.pvis.gui.guielement.button.DefaultButtonMouseEventHandler;
import com.logistics.pvis.gui.guilayer.GuiLayer;
import com.logistics.pvis.gui.guilayer.GuiLayerFactory;
import com.logistics.pvis.scene.BaseScene;
import com.logistics.pvis.scene.BaseSceneFactory;
import com.logistics.pvis.scene.Scene;
import com.logistics.pvis.scene.SceneBuilder;

public class StartSceneBuilder implements SceneBuilder {

	private ProcessingFrame frame;

	public StartSceneBuilder(ProcessingFrame frame) {
		this.frame = frame;
	}

	@Override
	public Scene BuildScene() {
		BaseScene scene = CreateScene();
		
		GuiLayer guiLayer = CreateGuiLayer();
		scene.addLayer(guiLayer);
		
		return scene;
	}

	private BaseScene CreateScene() {
		BaseSceneFactory baseSceneFactory = new BaseSceneFactory();
		BaseScene scene = baseSceneFactory.produceBaseScene();
		return scene;
	}

	private GuiLayer CreateGuiLayer() {
		GuiLayerFactory guiLayerFactory = new GuiLayerFactory();
		GuiLayer guiLayer = guiLayerFactory.produceGuiLayer(frame);
		
		Button button = CreateStartButton(guiLayer);
		guiLayer.addGuiElement(button);
		
		return guiLayer;
	}

	private Button CreateStartButton(GuiLayer guiLayer) {
		ButtonFactory buttonFactory = new ButtonFactory(guiLayer, guiLayer);
		Button button = buttonFactory.produceButton("Start", 
				AnchorPoint.MiddleCenter, 
				new Dimension(0, 100, 200, 60));
		DefaultButtonMouseEventHandler handler = 
				new DefaultButtonMouseEventHandler(button);
		button.addMouseEventHandler(handler);
		return button;
	}

}
