/**
 * Logistics server side
 */
package com.logistics.visualizer;

import com.logistics.visualizer.scene.startscene.StartSceneBuilder;
import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.Scene;

import processing.core.*;

/**
 * 
 * A visualizer is an processing applet that can observe the simulation status
 * 
 * @author Yifan Sun
 *
 */
@SuppressWarnings("serial")
public class Visualizer extends PApplet {
	
	/**
	 * Constructor
	 */
	public Visualizer() {
	}
	
	/**
	 * Current scene
	 */
	protected Scene currentScene;
	
	/**
	 * @return the currentScene
	 */
	public Scene getCurrentScene() {
		return currentScene;
	}

	/**
	 * @param currentScene the currentScene to set
	 */
	public void changeScene(String sceneName, Scene currentScene) {
		this.currentScene = currentScene;
	}

	/*
	 * (non-Javadoc)
	 * @see processing.core.PApplet#setup()
	 */
	public void setup(){
		size(960, 540, P2D);
		frameRate(60);
		
		// Create start scene
		StartSceneBuilder startSceneBuilder = new StartSceneBuilder(this);
		Scene startScene = startSceneBuilder.buildScene();
		this.changeScene("START_SCENE", startScene);
	}
	
	/*
	 * (non-Javadoc)
	 * @see processing.core.PApplet#draw()
	 */
	public void draw(){
		background(255);
		currentScene.render();
	}
	
	/**
	 * On click event
	 */
	public void mouseClicked(processing.event.MouseEvent event) {
		MouseEvent mouseEvent = new MouseEvent(event);
		currentScene.processMouseEvent(mouseEvent);
	}
	
	/**
	 * On mouse pressed event
	 */
	public void mousePressed(processing.event.MouseEvent event) {
		MouseEvent mouseEvent = new MouseEvent(event);
		currentScene.processMouseEvent(mouseEvent);
	}
	
	/**
	 * On mouse dragged event
	 */
	public void mouseDragged(processing.event.MouseEvent event) {
		MouseEvent mouseEvent = new MouseEvent(event);
		currentScene.processMouseEvent(mouseEvent);
	}
	
	/**
	 * On mouse released event
	 */
	public void mouseReleased(processing.event.MouseEvent event) {
		MouseEvent mouseEvent = new MouseEvent(event);
		currentScene.processMouseEvent(mouseEvent);
	}
	
	/**
	 * Process key pressed event
	 */
	public void keyPressed(processing.event.KeyEvent event) {
		KeyEvent keyEvent = new KeyEvent(event);
		currentScene.processKeyEvent(keyEvent);
	}
	
	/**
	 * Process the mouse scroll event
	 */
	public void mouseWheel(processing.event.MouseEvent event){
		MouseEvent mouseEvent = new MouseEvent(event);
		currentScene.processMouseEvent(mouseEvent);
	}
	
}
