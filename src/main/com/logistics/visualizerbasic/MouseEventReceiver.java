/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public interface MouseEventReceiver {
	public void processMouseEvent(MouseEvent event);
	public void setMouseEventHandler(MouseEventHandler handler);
}
