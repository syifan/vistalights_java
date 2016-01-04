/**
 * Logistics server side
 */
package com.logistics.visualizerbasic.gui;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import processing.core.PApplet;

/**
 * @author yifansun
 *
 */
public class GuiElementTest {
	
	class MockupGuiContainer implements GuiContainer{
		
		@Override
		public double getX() {
			return 100;
		}

		@Override
		public double getY() {
			return 200;
		}

		@Override
		public double getWidth() {
			return 1000;
		}

		@Override
		public double getHeight() {
			return 800;
		}

		@Override
		public void addSubGuiElement(GuiElement guiElement) {}

		@Override
		public Set<GuiElement> getSubGuiElements() {
			return null;
		}
		
	}

	class MockupGuiElement extends GuiElement {

		/**
		 * @param visualizer
		 * @param gui
		 * @param parent
		 * @param x
		 * @param y
		 * @param width
		 * @param height
		 */
		public MockupGuiElement(PApplet visualizer, GuiLayer gui,
				GuiContainer parent, double x, double y, double width,
				double height) {
			super(visualizer, gui, parent, x, y, width, height);
			// TODO Auto-generated constructor stub
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.Renderable#render()
		 */
		@Override
		public void render() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Test
	public void testSetAnchorPoint() {
		GuiContainer container = new MockupGuiContainer();
		GuiElement element = new MockupGuiElement(null, null, container, 
				10, 20, 30, 40);
		
		// Default is left-top corner
		assertEquals(110, element.absX, 1e-5);
		assertEquals(220, element.absY, 1e-5);
		
		// Set anchor point 1, 1 should not change the value
		element.setAnchorPoint(1, 1);
		assertEquals(110, element.absX, 1e-5);
		assertEquals(220, element.absY, 1e-5);
		
		// Set to anchor point 2, 2
		element.setAnchorPoint(2, 2);
		assertEquals(100 + 500 - 15 + 10, element.absX, 1e-5);
		assertEquals(200 + 400 - 20 + 20, element.absY, 1e-5);
		
		// Set to anchor point 3, 3
		element.setAnchorPoint(3, 3);
		assertEquals(100 + 1000 - 30 - 10, element.absX, 1e-5);
		assertEquals(200 + 800 - 40 - 20, element.absY, 1e-5);
	}

}
