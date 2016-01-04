/**
 * Logistics server side
 */
package com.logistics.simulator.map;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logistics.shared.Point3D;
import com.logistics.simulator.buildingsystem.Dock;
import com.logistics.simulator.buildingsystem.MapMarginPoint;
import com.logistics.simulator.network.Network;
import com.logistics.simulator.network.NetworkImpl;

/**
 * A map holds all the information about of the game. 
 * It includes tile setups, road systems, initial state of ships and 
 * scheduled accident.
 * 
 * @author yifansun
 *
 */
public class Map {
	
	/**
	 * A list of docks
	 */
	protected List<Dock> docks = new ArrayList<Dock>();
	
	/**
	 * A list of map margin points
	 */
	protected List<MapMarginPoint> mapMarginPoints = 
			new ArrayList<MapMarginPoint>();
	
	/**
	 * Map events
	 */
	protected Set<MapEvent> mapEvents = new HashSet<MapEvent>();
	
	/**
	 * The image where black is for water and white is for land
	 */
	protected BufferedImage waterMask;
	
	/**
	 * Network
	 */
	protected Network network = new NetworkImpl();
	
	/**
	 * @param waterMask the waterMask to set
	 */
	public void setWaterMask(BufferedImage waterMask) {
		this.waterMask = waterMask;
	}

	/**
	 * Check if one point is water
	 * @param point
	 * @return
	 */
	public boolean isWater(Point3D point) {
		int x = (int) (point.getX() / 100);
		int y = (int) (point.getY() / 100);
		int rgb = waterMask.getRGB(x, y);
		int red = (rgb >> 16) & 0xFF;
		int green = (rgb >> 8) & 0xFF;
		int blue = rgb & 0xFF;
		if (red == 0 && green == 0 && blue == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param dock
	 */
	public void addDock(Dock dock) {
		synchronized (docks) {
			this.docks.add(dock);
		}
	}
	
	/**
	 * Get all docks
	 * @return
	 */
	public List<Dock> getDocks() {
		return docks;
	}
	
	/**
	 * Add a map margin point
	 * @param mapMarginPoint
	 */
	public void addMapMarginPoint(MapMarginPoint mapMarginPoint) {
		this.mapMarginPoints.add(mapMarginPoint);
	}
	
	/**
	 * Get the list of map margins
	 * @return
	 */
	public List<MapMarginPoint> getMapMarginPoints() {
		return this.mapMarginPoints;
	}
	
	/**
	 * Get network
	 * @return
	 */
	public Network getNetwork() {
		return network;
	}
	
	/**
	 * Set network
	 * @param network
	 */
	public void setNetwork(Network network) {
		this.network = network;
	}
	
	/**
	 * Add map events
	 * @param mapEvent
	 */
	public void addMapEvent(MapEvent mapEvent) {
		this.mapEvents.add(mapEvent);
	}
	
	/**
	 * Get map events
	 * @return
	 */
	public Set<MapEvent> getMapEvents() {
		return mapEvents;
	}
	
}
