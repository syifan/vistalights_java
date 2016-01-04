/**
 * Logistics server side
 */
package com.logistics.apisystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.simulator.Simulator;

/**
 * @author yifansun
 *
 */
public class ClientConnection implements Runnable {

	/**
	 * Socket connect to the client
	 */
	private Socket socket;
	
	/**
	 * Input stream
	 */
	private InputStream in;
	
	/**
	 * Output stream 
	 */
	private OutputStream out;
	
	/**
	 * Buffer
	 */
	private byte[] buffer = new byte[1000];
	
	/**
	 * Simulator
	 */
	Simulator simulator;
	
	/**
	 * Constructor
	 */
	public ClientConnection() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		while (true)
		{
			try{
				int numBytes = in.read(buffer);
				String str = new String(buffer, 0, numBytes);
				if (numBytes > 0) {
					System.out.format("Received from client: %s\n", str);
				}
				String action = parseAction(str);
				switch(action) {
				case "game speed":
					changeGameSpeed(str);
					break;
				case "change priority":
					changePriority(str);
					break;
				}
			}
			catch (Exception e){
				// APIManager.getInstance().clientDisconnect(this);
				return;
			}
		}

	}
	
	/**
	 * @param str
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	protected void changePriority(String json) throws Exception {
		/*
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mapJson = mapper.readValue(json, JsonNode.class);
		long id  = mapJson.get("data").get("vehicle_id").asLong();
		int priority = mapJson.get("data").get("priority").asInt();
		simulator.changeVehiclePriority(id, priority);
		*/
	}

	/**
	 * @param str
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	protected void changeGameSpeed(String json) throws Exception {
		/*
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mapJson = mapper.readValue(json, JsonNode.class);
		int speed = mapJson.get("speed").asInt();
		switch(speed) {
		case 0:
			scheduler.setTimeScale(0);
			break;
		case 1:
			scheduler.setTimeScale(100);
			break;
		case 2:
			scheduler.setTimeScale(300);
			break;
		case 3:
			scheduler.setTimeScale(1000);
			break;
		default:
			break;	
		}
		*/
	}

	/**
	 * Write to the client
	 */
	public void write(String data)
	{
		//System.out.print(data);
		byte[] bytes = data.getBytes();
		int length = data.length();
		try {
			out.write(bytes, 0, length);
			out.flush();
		}
		catch (IOException e)
		{
			// APIManager.getInstance().clientDisconnect(this);
			// e.printStackTrace();
		}
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
		System.out.format("Client %s connected\n", socket.getInetAddress().toString());
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	/**
	 * @param json
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public String parseAction(String json) throws 
		JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mapJson = mapper.readValue(json, JsonNode.class);
		String action = mapJson.get("action").asText();
		return action;
	}

}
