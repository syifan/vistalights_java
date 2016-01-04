/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.startscene;

import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;
import com.logistics.visualizerbasic.Scene;
import com.logistics.visualizerbasic.SceneBuilder;

/**
 * @author yifansun
 *
 */
public class StartButtonMouseEventHandler implements MouseEventHandler {
	
	/**
	 * Visualizer
	 */
	public Visualizer visualizer;
	
	/**
	 * The scene builder for next scene
	 */
	public SceneBuilder nextSceneBuilder;

	/**
	 * @param visualizer
	 * @param nextSceneBuilder
	 */
	public StartButtonMouseEventHandler(Visualizer visualizer,
			SceneBuilder nextSceneBuilder) {
		super();
		this.visualizer = visualizer;
		this.nextSceneBuilder = nextSceneBuilder;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#propagateMouseEvent(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void propagateMouseEvent(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseClicked(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		Scene nextScene = nextSceneBuilder.buildScene();
		visualizer.changeScene("ORGANIZE_SCENE", nextScene);
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mousePressed(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseReleased(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseDragged(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.MouseEventHandler#mouseWheel(com.logistics.visualizerbasic.MouseEvent)
	 */
	@Override
	public void mouseWheel(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
