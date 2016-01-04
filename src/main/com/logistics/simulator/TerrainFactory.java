/**
 * Logistics server side
 */
package com.logistics.simulator;

/**
 * @author yifansun
 *
 */
public class TerrainFactory {
	/**
	 * @param scheduler
	 */
	public TerrainFactory() {
	}

	/**
	 * Create a terrain object and return it
	 * @return
	 */
	public Terrain produceTerrain() {
		Terrain terrain = new Terrain();
		return terrain;
	}
}
