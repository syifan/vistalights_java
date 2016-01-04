/**
 * Logistics server side
 */
package com.logistics.mapeditor;

import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;

import processing.core.PApplet;

/**
 * @author yifan
 *
 */
@SuppressWarnings("serial")
public class MapEditor extends PApplet {
	
	private Scene currentScene;
	
	/*
	 * (non-Javadoc)
	 * @see processing.core.PApplet#setup()
	 */
	public void setup(){
		size(960, 540, P2D);
		frameRate(120);
		
		SceneBuilder sceneBuilder = new EditMapSceneBuilder(this);
		currentScene = sceneBuilder.buildScene();
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
