/**
 * Logistics server side
 */
package com.logistics.apisystem;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.logistics.simulator.ScoreManager;
import com.logistics.simulator.vehicle.Vehicle;

/**
 * An API Manager creates a server clients and manages user that connects in
 * 
 * @author yifansun
 *
 */
public class ApiManagerImpl implements Runnable, ApiManager  {
	
	/**
	 * Server socket
	 */
	private ServerSocket serverSocket;
	
	/**
	 * A list of user info subscriber
	 */
	protected ArrayList<UserInfoSubscriber> userInfoSubscribers = 
			new ArrayList<UserInfoSubscriber>();
	
	/**
	 * A list of client connections
	 */
	private ArrayList<ClientConnection> clients;
	
	/**
	 * The index to be allocated for user index
	 */
	protected Integer nextUserIndex = 1;

	/**
	 * Determines if game is stopped
	 */
	private boolean stopped;
	
	/**
	 * Constructor
	 */
	public ApiManagerImpl() {
		try {
			serverSocket = new ServerSocket(8000);
			// serverSocket.setSoTimeout(10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Init clients
		clients = new ArrayList<ClientConnection>(4);
	}
	
	/**
	 * 
	 * @param vehicle
	 */
	public void removeShip(Vehicle vehicle) {
		/*
		// ViewManager.getInstance().getCurrentView().removeVehicle(vehicle);
		String data = String.format(
				"{"
				+ "\"action\": \"ship remove\","
				+ "\"vehicle\": %s"
				+ "}", 
				vehicle.toJson()
			);
		broadcast(data);
		*/
	}
	
	/**
	 * 
	 * @param score
	 */
	public void scoreUpdate(ScoreManager score) {
		String data = String.format("{"
				+ "\"action\": \"score update\","
				+ "\"score\": %s"
				+ "}", score.toJson());
		//System.out.println(data);
		broadcast(data);
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.apisystem.ApiManager#broadcast(java.lang.String)
	 */
	@Override
	public void broadcast(String string){
		if (stopped) return;
		System.out.format("Broadcasting: %s\n", string);
		for(int i = 0; i < clients.size(); i++){
			ClientConnection client = clients.get(i);
			client.write(string);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true){
			try{
				Socket server = serverSocket.accept();
				ClientConnection connection = new ClientConnection();
				connection.setSocket(server);
				this.clients.add(connection);
				new Thread(connection).start();
				System.out.println("User connected");
				
				// Create user
				this.createUser();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Create an user and inform user info subscriber
	 */
	protected User createUser() {
		User user = new User(nextUserIndex);
		
		// Increase next user index
		nextUserIndex++;
		
		// Inform user subscriber
		for (UserInfoSubscriber subscriber : userInfoSubscribers) {
			subscriber.userConnect(user);
		}
		
		// Return user
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.logistics.apisystem.ApiManager#getNumberConnectedClient()
	 */
	@Override
	public int getNumberConnectedClient() {
		return clients.size();
	}

	/* (non-Javadoc)
	 * @see com.logistics.apisystem.ApiManager#clientDisconnect(com.logistics.apisystem.ClientConnection)
	 */
	@Override
	public void clientDisconnect(ClientConnection clientConnection) {
		System.out.format("User %s has left the game.\n", 
				clientConnection.getSocket().getInetAddress().toString());
		this.clients.remove(clientConnection);		
	}

	/**
	 * 
	 * @param worldTime
	 */
	public void updateTime(LocalDateTime worldTime) {
		String data = String.format(
				"{"
				+ "\"action\": \"time\","
				+ "\"time\": \"%s\""
				+ "}", 
				worldTime.toString()
			);
		broadcast(data);
	}


	/**
	 * 
	 */
	public void stopGame() {
		/*
		String data = String.format("{"
				+ "\"action\": \"game over\","
				+ "\"score\": %f}", 
				Simulator.getInstance().getEconomicScoreManager().getScore());
		System.out.println(data);
		this.stopped = true;
		broadcast(data);
		*/
	}

	/* (non-Javadoc)
	 * @see com.logistics.apisystem.ApiManager#addUserInfoSubscriber(com.logistics.apisystem.UserInfoSubscriber)
	 */
	@Override
	public void addUserInfoSubscriber(UserInfoSubscriber subscriber) {
		this.userInfoSubscribers.add(subscriber);		
	}

}
