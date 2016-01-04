/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.pathfinder.PathFinder;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.scheduler.path.Path;
import com.logistics.simulator.vehicle.task.TaskReserver;
import com.logistics.simulator.vehicle.task.VehicleTask;

/**
 * @author Yifan
 *
 */
public class VehicleSchedulerImpl implements VehicleScheduler {

	protected Vehicle vehicle;
	protected LocalDateTime currentTime;
	protected Network network;
	protected PathFinder pathFinder;
	protected ScheduleCreator scheduleCreator;
	protected ConflictResolver conflictResolver;
	
	protected Set<Path> paths;
	protected Set<Schedule> schedules;
	
	/**
	 * 
	 * @param network
	 * @param pathFinder
	 * @param scheduleCreator
	 * @param conflictResolver
	 */
	public VehicleSchedulerImpl( 
			Network network,
			PathFinder pathFinder,
			ScheduleCreator scheduleCreator, 
			ConflictResolver conflictResolver) {
		super();
		this.network = network;
		this.pathFinder = pathFinder;
		this.scheduleCreator = scheduleCreator;
		this.conflictResolver = conflictResolver;
	}
	
	private void findAllPaths() {
		try {
			if(vehicleHasArrivedPort()) {
				findAllPathsToLeave();
			} else {
				findAllPathsToUnloadAndLeave();
			}
		} catch (NoPathFoundException e) {
			processNoPathFoundException(e);
		}
	}
	
	private boolean vehicleHasArrivedPort() {
		if (vehicle.hasUnloaded()) {
			return true;
		} else if (vehicleIsAtPort()) {
			return true;
		}
		return false;
	}

	private boolean vehicleIsAtPort() {
		Node startNode = network.getNearestNode(vehicle.getPosition());
		if (startNode.getId() == vehicle.getUnloadNodeId()) {
			return true;
		}
		return false;
	}

	private void processNoPathFoundException(NoPathFoundException e) {
		System.out.println("No path found!");
		System.out.println(e.getMessage());
	}
	
	private void findAllPathsToUnloadAndLeave() throws NoPathFoundException {
		Set<Path> pathsToDock = new HashSet<Path>();
		Node startNode = network.getNearestNode(vehicle.getPosition());
		pathsToDock = pathFinder.findPath(startNode.getId(), 
				vehicle.getUnloadNodeId());
		
		Set<Path> pathsToLeave = new HashSet<Path>();
		pathsToLeave = pathFinder.findPath(vehicle.getUnloadNodeId(), 
				vehicle.getLeaveNodeId());
		
		for (Path path1 : pathsToDock) {
			for (Path path2 : pathsToLeave) {
				this.paths.add(path1.joinPath(path2));
			}
		}
		
		if (paths.isEmpty()) {
			throw new NoPathFoundException(
					String.format("From %d, unloading at %d, leave at %d", 
							startNode.getId(), 
							vehicle.getUnloadNodeId(), 
							vehicle.getLeaveNodeId()));
		}
	}

	private void findAllPathsToLeave() throws NoPathFoundException {
		Node startNode = network.getNearestNode(vehicle.getPosition());
		this.paths = pathFinder.findPath(startNode.getId(), 
				vehicle.getLeaveNodeId());
		
		if (paths.isEmpty()) {
			throw new NoPathFoundException(
					String.format("From %d, leave at %d", 
							startNode.getId(),  
							vehicle.getLeaveNodeId()));
		}
		
	}

	protected void paths2Schedules() {
		for (Path path : paths) {
			Schedule schedule = scheduleCreator.createSchedule(vehicle, path, 
					currentTime);
			this.schedules.add(schedule);
		}
	}
	
	protected void findEarliestTime() {
		for (Schedule schedule : schedules) {
			conflictResolver.resolve(schedule);
		}
	}
	
	protected Schedule findBestSchedule() {
		LocalDateTime earliestETA = null;
		Schedule selectedSchedule = null;
		for (Schedule schedule : schedules) {
			if (earliestETA == null) {
				earliestETA = schedule.getETA();
				selectedSchedule = schedule;
				continue;
			}
			if (schedule.getETA().isBefore(earliestETA)) {
				earliestETA = schedule.getETA();
				selectedSchedule = schedule;
			}
		}
		return selectedSchedule;
	}
	
	/**
	 * @param bestSchedule
	 */
	private void reserveBestSchedule(Schedule schedule) {
		List<VehicleTask> tasks = schedule.getTasks();
		for (VehicleTask task : tasks) {
			TaskReserver reserver = task.getTaskReserver();
			reserver.makeReservation();
		}
	}

	/* (non-Javadoc)
	 * @see com.logistics.simulator.vehicle.VehicleScheduler#schedule()
	 */
	@Override
	public Schedule schedule(Vehicle vehicle, LocalDateTime currentTime) {
		this.vehicle = vehicle;
		this.currentTime = currentTime;
		paths = new HashSet<Path>();
		schedules = new HashSet<Schedule>();
		this.findAllPaths();
		this.paths2Schedules();
		this.findEarliestTime();
		Schedule bestSchedule = this.findBestSchedule();
		vehicle.setSchedule(bestSchedule);
		this.reserveBestSchedule(bestSchedule);
		return bestSchedule;
	}

}
