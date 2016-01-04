/**
 * Logistics server side

 */
package com.logistics.apisystem;

/**
 * @author yifan
 *
 */
public interface ApiManager {

	/**
	 * Broadcast some information to all connected client
	 */
	public abstract void broadcast(String string);

	/**
	 * Return the number of client connected
	 */
	public abstract int getNumberConnectedClient();

	/**
	 * 
	 * @param clientConnection
	 */
	public abstract void clientDisconnect(ClientConnection clientConnection);

	/**
	 * Add an subscriber of user connection info
	 * @param organizeLogicController
	 */
	public abstract void addUserInfoSubscriber(UserInfoSubscriber subscriber);

}