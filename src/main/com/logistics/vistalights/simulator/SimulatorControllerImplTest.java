/**
 * Logistics server side
 */
package com.logistics.simulator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.logistics.simulator.vehicle.VehicleController;

/**
 * @author yifan
 *
 */
public class SimulatorControllerImplTest {
	
	class MockUpVehicleController implements VehicleController {
		protected int executed = 0;
		/* (non-Javadoc)
		 * @see com.logistics.simulator.vehicle.VehicleController#tick()
		 */
		@Override
		public void tick() {
			executed++;
		}
		
	}
	/**
	 * Test method for {@link com.logistics.simulator.SimulatorControllerImpl#tick()}.
	 */
	@Test
	public void testTick() {
		MockUpVehicleController vc1 = new MockUpVehicleController();
		MockUpVehicleController vc2 = new MockUpVehicleController();

		SimulatorController simulatorController = 
				new SimulatorControllerImpl(null);
		simulatorController.addVehicleController(vc1);
		simulatorController.addVehicleController(vc2);
		
		simulatorController.tick();
		
		assertEquals(1, vc1.executed);
		assertEquals(1, vc2.executed);

	}

}
