/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public interface MouseEventHandler {
	public void propagateMouseEvent(MouseEvent event);
	public void mouseClicked(MouseEvent event);
	public void mousePressed(MouseEvent event);
	public void mouseReleased(MouseEvent event);
	public void mouseDragged(MouseEvent event);
	public void mouseWheel(MouseEvent event);
}
