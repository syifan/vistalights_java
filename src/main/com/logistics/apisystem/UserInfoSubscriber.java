/**
 * Logistics server side
 */
package com.logistics.apisystem;

/**
 * @author yifansun
 *
 */
public interface UserInfoSubscriber {
	
	/**
	 * Notify subscriber the connection of a user
	 * @param user
	 */
	public void userConnect(User user);
	
	/**
	 * Notify subscriber the disconnection of a user
	 * @param user
	 */
	public void userDisconnect(User user);
	
}
