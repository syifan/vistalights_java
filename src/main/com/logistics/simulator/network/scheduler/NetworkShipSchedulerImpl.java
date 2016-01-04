/**
 * Logistics server side
 */
package com.logistics.simulator.network.scheduler;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.logistics.simulator.Simulator;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.RoadConnection;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.scheduler.VehicleScheduler;

/**
 * @author Yifan
 *
 */
public class NetworkShipSchedulerImpl implements NetworkShipScheduler {
	
	protected Simulator simulator;
	protected Scheduler scheduler;
	protected Network network;
	protected VehicleScheduler vehicleScheduler;

	/**
	 * @param simulator
	 * @param vehicleScheduler
	 */
	public NetworkShipSchedulerImpl(Simulator simulator, Scheduler scheduler, 
			Network network, VehicleScheduler vehicleScheduler) {
		super();
		this.simulator = simulator;
		this.scheduler = scheduler;
		this.network = network;
		this.vehicleScheduler = vehicleScheduler;
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.NetworkShipScheduler#schedule()
	 */
	@Override
	public void schedule() {
		// Clear all the reserved time slot
		Map<Integer, Node> nodes = network.getNodes();
		for (Map.Entry<Integer, Node> pair : nodes.entrySet()) {
			Node node = pair.getValue();
			node.clearAllResearvation();
			Set<RoadConnection> connections = node.getConnections();
			for (RoadConnection connection : connections) {
				connection.clearAllResearvation();
			}
		}
		
		// Clear all vehicle schedules
		Map<Integer, Vehicle> vehicles = simulator.getVehicles();
		synchronized(vehicles) {
			Collection<Vehicle> vehicleCollection = vehicles.values();
			for (Vehicle vehicle : vehicleCollection) {
				vehicle.setSchedule(null);
			}
		}
		
		// Reschedule
		synchronized(vehicles) {
			TreeMap<Integer, Vehicle> priorityQueue = 
					new TreeMap<Integer, Vehicle>();
			Collection<Vehicle> vehicleCollection = vehicles.values();
			for (Vehicle vehicle : vehicleCollection) {
				priorityQueue.put(vehicle.getId(), vehicle);
			}
			
			// Schedule all vehicles
			Iterator<Map.Entry<Integer, Vehicle>> it = 
					priorityQueue.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<Integer, Vehicle> pair = it.next();
				vehicleScheduler.schedule(pair.getValue(), 
						scheduler.getVirtualTime());
			}
		}
	}

}
