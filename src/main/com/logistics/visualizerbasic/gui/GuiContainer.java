/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import java.util.Set;

/**
 * A GuiContainer is an object that can contains other GUI elements
 * @author yifan
 *
 */
public interface GuiContainer {
	public double getX();
	public double getY();
	public double getWidth();
	public double getHeight();
	public void addSubGuiElement(GuiElement guiElement);
	public Set<GuiElement> getSubGuiElements();
}
