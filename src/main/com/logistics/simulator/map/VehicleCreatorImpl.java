/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.logistics.shared.Point3D;
import com.logistics.simulator.ScoreManager;
import com.logistics.simulator.Simulator;
import com.logistics.simulator.SimulatorController;
import com.logistics.simulator.business.IndustryType;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.node.Node;
import com.logistics.simulator.network.scheduler.NetworkShipScheduler;
import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.simulator.vehicle.Vehicle;
import com.logistics.simulator.vehicle.VehicleController;
import com.logistics.simulator.vehicle.VehicleControllerImpl;
import com.logistics.simulator.vehicle.VehicleFactory;
import com.logistics.simulator.vehicle.cargo.CargoContainer;
import com.logistics.simulator.vehicle.cargo.CargoScoreCounter;
import com.logistics.simulator.vehicle.task.TaskRunner;
import com.logistics.simulator.vehicle.task.TaskRunnerImpl;

/**
 * @author Yifan
 *
 */
public class VehicleCreatorImpl implements VehicleCreator {
	private VehicleFactory vehicleFactory;
	private Simulator simulator;
	private SimulatorController simulatorController;
	private Network network;
	private NetworkShipScheduler networkShipScheduler;
	private Scheduler scheduler;
	private ScoreManager economicScore;
	
	/**
	 * Constructor
	 * @param vehicleFactory
	 * @param simulator
	 * @param vehicleViewObjectFactory
	 * @param viewPort
	 */
	public VehicleCreatorImpl(VehicleFactory vehicleFactory,
			Simulator simulator,
			SimulatorController simulatorController,
			Network network,
			NetworkShipScheduler networkShipScheduler,
			Scheduler scheduler, 
			ScoreManager economicScore) {
		super();
		this.vehicleFactory = vehicleFactory;
		this.simulator = simulator;
		this.simulatorController = simulatorController;
		this.network = network;
		this.networkShipScheduler = networkShipScheduler;
		this.scheduler = scheduler;
		this.economicScore = economicScore;
	}



	/* (non-Javadoc)
	 * @see com.logistics.simulator.map.VehicleCreator#createVehicle()
	 */
	@Override
	public void createVehicle(JsonNode json) {
		System.out.println("Create a vehicle");
		
		Vehicle vehicle = vehicleFactory.produceVehicle(json.get("id").asInt());
		vehicle.setSize(new Point3D(60, 300, 0));
		vehicle.setHeading(new Point3D(1, 0, 0));
		if (json.get("node") != null) {
			Node node = network.getNodeById(json.get("node").asInt());
			vehicle.setPosition(node.getPosition());
		}
		if (json.get("unloading_node") != null) {
			vehicle.setUnloadNodeId(json.get("unloading_node").asInt());
		}
		if (json.get("leaving_node") != null) {
			vehicle.setLeaveNodeId(json.get("leaving_node").asInt());
		}
		if (json.get("industry") != null) {
			vehicle.setInsdustryType(IndustryType.valueOf(
					json.get("industry").asText()));
		}
		if (json.get("tonnage") != null) {
			double tonnage = json.get("tonnage").asDouble();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
					"yyyy-MM-dd HH:mm:ss");
			LocalDateTime dueTime = LocalDateTime.parse(
					json.get("cargo_due").asText(), formatter);
			CargoContainer cargoContainer = 
					new CargoContainer(tonnage, dueTime);
			cargoContainer.setCargoScoreCounter(new CargoScoreCounter(
					scheduler, cargoContainer, economicScore));
			vehicle.setCargoContainer(cargoContainer);
		}
		simulator.addVehicle(vehicle);
		
		// Create vehicle controller
		TaskRunner taskRunner = new TaskRunnerImpl(scheduler);
		VehicleController vehicleController = 
				new VehicleControllerImpl(vehicle, taskRunner);
		simulatorController.addVehicleController(vehicleController);
		
		// Reschedule 
		networkShipScheduler.schedule();
	}

}
