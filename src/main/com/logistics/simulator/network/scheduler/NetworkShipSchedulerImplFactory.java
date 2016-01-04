/**
 * Logistics server side
 */
package com.logistics.simulator.network.scheduler;

import com.logistics.simulator.Simulator;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.pathfinder.BfsPathFinder;
import com.logistics.simulator.network.pathfinder.PathFinder;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.VehicleRemover;
import com.logistics.simulator.vehicle.scheduler.ConflictResolver;
import com.logistics.simulator.vehicle.scheduler.ConflictResolverImpl;
import com.logistics.simulator.vehicle.scheduler.ScheduleCreator;
import com.logistics.simulator.vehicle.scheduler.ScheduleCreatorImpl;
import com.logistics.simulator.vehicle.scheduler.ScheduleImplFactory;
import com.logistics.simulator.vehicle.scheduler.VehicleScheduler;
import com.logistics.simulator.vehicle.scheduler.VehicleSchedulerImpl;
import com.logistics.simulator.vehicle.task.leavetask.LeaveTaskFactoryImpl;
import com.logistics.simulator.vehicle.task.movetask.MoveVehicleTaskFactory;
import com.logistics.simulator.vehicle.task.unloadingtask.UnloadingTaskFactoryImpl;

/**
 * @author Yifan
 *
 */
public class NetworkShipSchedulerImplFactory implements
		NetworkShipSchedulerFactory {

	private Simulator simulator;
	private Scheduler scheduler;
	private Network network;
	private VehicleRemover vehicleRemover;
	
	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.NetworkShipSchedulerFactory#produceNetworkShipScheduler()
	 */
	@Override
	public NetworkShipScheduler produceNetworkShipScheduler() {
		PathFinder pathFinder = new BfsPathFinder(network);
		ScheduleCreator schedulerCreator = new ScheduleCreatorImpl(network, 
				new ScheduleImplFactory(), 
				new MoveVehicleTaskFactory(scheduler),
				new UnloadingTaskFactoryImpl(),
				new LeaveTaskFactoryImpl(vehicleRemover));
		ConflictResolver conflictResolver = new ConflictResolverImpl();
		VehicleScheduler vehicleScheduler = new VehicleSchedulerImpl(network, 
				pathFinder, schedulerCreator, conflictResolver);
		NetworkShipSchedulerImpl networkShipSchedulerImpl = 
				new NetworkShipSchedulerImpl(simulator, scheduler, 
						network, vehicleScheduler );
		return networkShipSchedulerImpl;
	}

	/**
	 * @param simulator
	 * @param scheduler
	 * @param network
	 */
	public NetworkShipSchedulerImplFactory(Simulator simulator,
			Scheduler scheduler, Network network,
			VehicleRemover vehicleRemover) {
		super();
		this.simulator = simulator;
		this.scheduler = scheduler;
		this.network = network;
		this.vehicleRemover = vehicleRemover;
	}

}
