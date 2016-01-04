/**
 * Logistics server side
 */
package com.logistics.apisystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.logistics.shared.Point3D;
import com.logistics.simulator.business.IndustryType;
import com.logistics.simulator.vehicle.cargo.CargoContainer;
import com.logistics.simulator.vehicle.scheduler.Schedule;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleSerializer;
import com.logistics.visualizer.viewport.ViewObject;

/**
 * @author yifan
 *
 */
public class AddVehicleNotifierTest {

	class MockupApiManager implements ApiManager {
		
		public String info = "";
		/*
		 * (non-Javadoc)
		 * @see com.logistics.apisystem.APIManager#broadcast(java.lang.String)
		 */
		@Override
		public void broadcast(String data) {
			info += data;
		}
		/* (non-Javadoc)
		 * @see com.logistics.apisystem.ApiManager#getNumberConnectedClient()
		 */
		@Override
		public int getNumberConnectedClient() {
			// TODO Auto-generated method stub
			return 0;
		}
		/* (non-Javadoc)
		 * @see com.logistics.apisystem.ApiManager#clientDisconnect(com.logistics.apisystem.ClientConnection)
		 */
		@Override
		public void clientDisconnect(ClientConnection clientConnection) {
			// TODO Auto-generated method stub
			
		}
		/* (non-Javadoc)
		 * @see com.logistics.apisystem.ApiManager#addUserInfoSubscriber(com.logistics.apisystem.UserInfoSubscriber)
		 */
		@Override
		public void addUserInfoSubscriber(UserInfoSubscriber subscriber) {
			// TODO Auto-generated method stub
			
		};
	}
	
	class MockupVehicle implements Vehicle {

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getId()
		 */
		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getPosition()
		 */
		@Override
		public Point3D getPosition() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setPosition(com.logistics.shared.Point3D)
		 */
		@Override
		public void setPosition(Point3D position) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getHeading()
		 */
		@Override
		public Point3D getHeading() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setHeading(com.logistics.shared.Point3D)
		 */
		@Override
		public void setHeading(Point3D heading) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getSize()
		 */
		@Override
		public Point3D getSize() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setSize(com.logistics.shared.Point3D)
		 */
		@Override
		public void setSize(Point3D size) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getSpeed()
		 */
		@Override
		public double getSpeed() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setSpeed(double)
		 */
		@Override
		public void setSpeed(double speed) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getPriority()
		 */
		@Override
		public int getPriority() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setPriority(int)
		 */
		@Override
		public void setPriority(int priority) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getUnloadNodeId()
		 */
		@Override
		public int getUnloadNodeId() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setUnloadNodeId(int)
		 */
		@Override
		public void setUnloadNodeId(int nodeId) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#hasUnloaded()
		 */
		@Override
		public boolean hasUnloaded() {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getLeaveNodeId()
		 */
		@Override
		public int getLeaveNodeId() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setLeaveNodeId(int)
		 */
		@Override
		public void setLeaveNodeId(int nodeId) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setSchedule(com.logistics.simulator.vehicle.Schedule)
		 */
		@Override
		public void setSchedule(Schedule schedule) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getSchedule()
		 */
		@Override
		public Schedule getSchedule() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#tick()
		 */
		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#leave()
		 */
		@Override
		public void leave() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getViewObject()
		 */
		@Override
		public ViewObject getViewObject() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setViewObject(com.logistics.visualizer.viewport.ViewObject)
		 */
		@Override
		public void setViewObject(ViewObject viewObject) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getCargoContainer()
		 */
		@Override
		public CargoContainer getCargoContainer() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setCargoContainer(com.logistics.simulator.vehicle.CargoContainer)
		 */
		@Override
		public void setCargoContainer(CargoContainer cargoContainer) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#getIndustryType()
		 */
		@Override
		public IndustryType getIndustryType() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.Vehicle#setInsdustryType(com.logistics.simulator.business.IndustryType)
		 */
		@Override
		public void setInsdustryType(IndustryType industryType) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MockupVehicleSerializer implements VehicleSerializer {
		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleSerializer#toString(com.logistics.simulator.vehicle.Vehicle)
		 */
		@Override
		public String toString(Vehicle vehicle) {
			return "VEHICLE";
		}
	}
	
	/**
	 * Test method for {@link com.logistics.apisystem.AddVehicleNotifier#addVehicleNotify(com.logistics.simulator.vehicle.Vehicle)}.
	 */
	@Test
	public void testAddVehicleNotify() {
		MockupApiManager apiManager = new MockupApiManager();
		MockupVehicleSerializer serializer = new MockupVehicleSerializer();
		AddVehicleNotifier notifier = new AddVehicleNotifier(apiManager, serializer);
		Vehicle vehicle = new MockupVehicle();
		notifier.addVehicleNotify(vehicle);
		assertEquals("{\"action\": \"ship create\",\"vehicle\": VEHICLE}", 
				apiManager.info);
	}

}
