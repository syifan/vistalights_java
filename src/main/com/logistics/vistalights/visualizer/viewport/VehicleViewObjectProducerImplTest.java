/**
 * Logistics server side
 */
package com.logistics.visualizer.viewport;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import processing.core.PGraphics;

import com.logistics.shared.Point2D;
import com.logistics.shared.Point3D;
import com.logistics.simulator.map.Map;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.KeyEvent;
import com.logistics.visualizerbasic.KeyEventHandler;
import com.logistics.visualizerbasic.MouseEvent;
import com.logistics.visualizerbasic.MouseEventHandler;

/**
 * @author Yifan
 *
 */
public class VehicleViewObjectProducerImplTest {
	
	class MockupViewPort implements ViewPort {
		
		public List<ViewObject> viewObjects  = new ArrayList<ViewObject>();
		
		/*
		 * (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.ViewPort#addViewObject(com.logistics.visualizer.viewport.ViewObject)
		 */
		@Override
		public void addViewObject(ViewObject viewObject) {
			viewObjects.add(viewObject);
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.Layer#getCanvas()
		 */
		@Override
		public PGraphics getCanvas() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.Layer#mousePosition(com.logistics.visualizerbasic.MouseEvent)
		 */
		@Override
		public Point2D mousePosition(MouseEvent event) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.Renderable#render()
		 */
		@Override
		public void render() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.MouseEventReceiver#processMouseEvent(com.logistics.visualizerbasic.MouseEvent)
		 */
		@Override
		public void processMouseEvent(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.MouseEventReceiver#setMouseEventHandler(com.logistics.visualizerbasic.MouseEventHandler)
		 */
		@Override
		public void setMouseEventHandler(MouseEventHandler handler) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.KeyEventReceiver#processKeyEvent(com.logistics.visualizerbasic.KeyEvent)
		 */
		@Override
		public void processKeyEvent(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizerbasic.KeyEventReceiver#setKeyEventHandler(com.logistics.visualizerbasic.KeyEventHandler)
		 */
		@Override
		public void setKeyEventHandler(KeyEventHandler handler) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.ViewPort#getCamera()
		 */
		@Override
		public ViewPortCamera getCamera() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.ViewPort#setCamera(com.logistics.visualizer.viewport.ViewPortCamera)
		 */
		@Override
		public void setCamera(ViewPortCamera camera) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.ViewPort#removeViewObject(com.logistics.visualizer.viewport.ViewObject)
		 */
		@Override
		public void removeViewObject(ViewObject viewObject) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.ViewPort#getViewObjects()
		 */
		@Override
		public Set<ViewObject> getViewObjects() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class MockupVehicleViewObjectFactory extends VehicleViewObjectFactory {

		/**
		 * @param visualizer
		 * @param viewPort
		 * @param camera
		 * @param map
		 */
		public MockupVehicleViewObjectFactory(Visualizer visualizer,
				ViewPort viewPort, ViewPortCamera camera, Map map) {
			super(visualizer, viewPort, camera, map);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.logistics.visualizer.viewport.VehicleViewObjectFactory#produceViewObject()
		 */
		@Override
		public ViewObject produceViewObject() {
			ViewObject viewObject = new MockupViewObject(null, null);
			viewObject.setPosition(new Point3D(10, 10, 10));
			return viewObject;
		}
		
	}
	
	class MockupViewObject extends ViewObject {

		/**
		 * @param visualizer
		 * @param viewPort
		 */
		public MockupViewObject(Visualizer visualizer, ViewPort viewPort) {
			super(visualizer, viewPort);
			// TODO Auto-generated constructor stub
		}
		
	}

	/**
	 * Test method for {@link com.logistics.visualizer.viewport.VehicleViewObjectProducerImpl#addVehilceNotify(com.logistics.simulator.vehicle.Vehicle)}.
	 */
	@Test
	public void testAddVehilceNotify() {
		MockupViewPort viewPort = new MockupViewPort();
		MockupVehicleViewObjectFactory factory = 
				new MockupVehicleViewObjectFactory(null, null, null, null);
		VehicleViewObjectProducer producer = 
				new VehicleViewObjectProducerImpl(viewPort , factory);
		producer.addVehicleNotify(null);
		assertEquals("Position as expected", new Point3D(10, 10, 10), 
				viewPort.viewObjects.get(0).getPosition());
		
	}

}
