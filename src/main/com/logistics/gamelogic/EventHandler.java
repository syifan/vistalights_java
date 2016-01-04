/**
 * Logistics server side
 */
package com.logistics.gamelogic;

/**
 * An event handler encapsulate a function that response to an event being 
 * triggered
 * 
 * @author yifansun
 *
 */
abstract public interface EventHandler {

	/**
	 * Process the event
	 */
	public void process();
	
}
