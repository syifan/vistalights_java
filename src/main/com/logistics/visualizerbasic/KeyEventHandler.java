/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public interface KeyEventHandler {
	public void propagateKeyEvent(KeyEvent event);
	public void keyPressed(KeyEvent event);
	public void keyReleased(KeyEvent event);
	public void keyTyped(KeyEvent event);
}
