package com.logistics.vistalights.application;

import com.logistics.pvis.application.Application;
import com.logistics.pvis.frame.ProcessingFrame;
import com.logistics.pvis.scene.Scene;
import com.logistics.vistalights.startscene.StartSceneBuilder;

public class VistaLights implements Application {

	ProcessingFrame frame;
	
	public VistaLights(ProcessingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void start() {
		StartSceneBuilder startSceneBuilder = new StartSceneBuilder(frame);
		Scene startScene = startSceneBuilder.BuildScene();
		
		frame.setCurrentScene(startScene);
	}

}
