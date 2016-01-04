/**
 * Logistics server side
 */
package com.logistics.simulator.vehicle.scheduler;

/**
 * @author Yifan
 *
 */
public class NoPathFoundException extends Exception {

	private static final long serialVersionUID = -5046986466578763785L;
	
	public NoPathFoundException(String message) {
		super("No path found, " + message);
	}

}
