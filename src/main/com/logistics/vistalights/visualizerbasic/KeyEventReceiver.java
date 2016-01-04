/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public interface KeyEventReceiver {
	public void processKeyEvent(KeyEvent event);
	public void setKeyEventHandler(KeyEventHandler handler);
}
