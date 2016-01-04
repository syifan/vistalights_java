/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle;

/**
 * @author yifan
 *
 */
public class VehicleJsonSerializer implements VehicleSerializer {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleSerializer#toString(com.logistics.simulator.vehicle.Vehicle)
	 */
	@Override
	public String toString(Vehicle vehicle) {
		String data = String.format(
				  "{"
				+   "\"vehicle_id\":%d,"
				+   "\"position\":{\"x\":%.1f,\"y\":%.1f,\"z\":%.1f},"
				+   "\"heading\":%.1f,"
				+   "\"priority\":%d,"
				+   "\"cargo\":{"
				+     "\"tonnage\":%.1f,"
				+     "\"due_time\":\"%s\","
				+     "\"perishable\":%b"
				+   "},"
				+   "\"industry\":\"%s\""
				+ "}", 
				vehicle.getId(),
				vehicle.getPosition().getX(),
				vehicle.getPosition().getY(),
				vehicle.getPosition().getZ(),
				1.0, 
				vehicle.getPriority(),
				vehicle.getCargoContainer().getTonnage(),
				vehicle.getCargoContainer().getDueTime().toString(),
				false,
				vehicle.getIndustryType().toString());
		
		return data;
	}

}
