/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.shared.Point3D;
import com.logistics.simulator.buildingsystem.DockCreator;
import com.logistics.simulator.buildingsystem.MapMarginPointCreator;
import com.logistics.simulator.network.loader.NetworkLoader;
import com.logistics.simulator.scheduler.Scheduler;

/**
 * @author Yifan Sun
 *
 */
public class MapLoader {
	
	protected Map map;
	
	protected Scheduler scheduler;
	
	protected DockCreator dockCreator;
	
	protected MapMarginPointCreator mapMarginPointCreator;

	private NetworkLoader networkLoader;
	
	private MapEventLoader mapEventLoader;
	
	/**
	 * @param dockCreator
	 */
	public MapLoader(Map map, Scheduler scheduler, DockCreator dockCreator, 
			MapMarginPointCreator mapMarginPointCreator,
			NetworkLoader networkLoader,
			MapEventLoader mapEventLoader) {
		super();
		this.map = map;
		this.scheduler = scheduler;
		this.dockCreator = dockCreator;
		this.mapMarginPointCreator = mapMarginPointCreator;
		this.networkLoader = networkLoader;
		this.mapEventLoader = mapEventLoader;
	}

	/**
	 * Load the map
	 * @param x
	 * @param y
	 * @param simulator
	 * @throws Exception
	 */
	public void loadMap() throws Exception {
		String waterMaskFileName = "maps/map(0,0)/water_mask_min.png";
		BufferedImage waterMask = ImageIO.read(new File(waterMaskFileName));
		map.setWaterMask(waterMask);
		
		// Load map from json file
		String mapFilePath = "maps/map.json";
		byte[] mapData = Files.readAllBytes(Paths.get(mapFilePath));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mapJson = mapper.readValue(mapData, JsonNode.class);
		
		// Start time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm:ss");
		LocalDateTime startTime = LocalDateTime.parse(
				mapJson.get("start_time").asText(), formatter);
		scheduler.setVirtualTime(startTime);
		
		// Create docks
		for (JsonNode node : mapJson.get("docks")) {
			//String dockName = node.get("name").asText();
			String dockIndustry = node.get("industry").asText();
			double x = node.get("position").get("x").asDouble();
			double y = node.get("position").get("y").asDouble();
			double z = node.get("position").get("z").asDouble();
			Point3D position = new Point3D(x, y, z);
			this.dockCreator.createDock("", position, dockIndustry);
		}
		
		// Load map margin points
		if (mapJson.get("map_margin_points") != null) {
			for (JsonNode node : mapJson.get("map_margin_points")) {
				Point3D position = new Point3D(
						node.get("position").get("x").asDouble(),
						node.get("position").get("y").asDouble(),
						node.get("position").get("z").asDouble());
				Point3D defaultDestination = new Point3D(
						node.get("default_destination").get("x").asDouble(),
						node.get("default_destination").get("y").asDouble(),
						node.get("default_destination").get("z").asDouble());
				this.mapMarginPointCreator.createMapMarginPoint(position, 
						defaultDestination);
			}
		}
		
		networkLoader.loadNetwork(mapJson.get("network"));
		if (mapJson.get("events") != null) {
			mapEventLoader.loadMapEvents(mapJson.get("events"));
		}
	}

}
