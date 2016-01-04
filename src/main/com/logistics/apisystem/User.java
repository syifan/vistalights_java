/**
 * Logistics server side
 */
package com.logistics.apisystem;

/**
 * A user is a player that connects to the system
 * @author yifansun
 *
 */
public class User {

	/**
	 *  Client socket
	 */
	protected ClientConnection connection;
	
	/**
	 *  Name of user
	 */
	protected String name;
	
	/**
	 * Index of the user
	 */
	protected Integer id;
	
	/**
	 * Constructor
	 */
	public User(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	
	
	
}
