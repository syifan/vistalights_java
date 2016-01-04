/**
 * Logistics server side
 */
package com.logistics.simulator;

/**
 * @author yifansun
 *
 */
public class ScoreManager {

	/**
	 * Score
	 */
	protected double score = 0;
	
	/**
	 * Type of the score
	 */
	protected String type;

	/**
	 * Constructor
	 * @param type Type of the score manager
	 */
	public ScoreManager(String type) {
		this.type = type;
	}

	/**
	 * Add an amount to the score, can be both positive and negative
	 * @param score The score to be added
	 */
	public void addScore(double score) {
		this.score += score;
		// System.out.format("%s score: %f\n", type, this.score);
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	};
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Express the score manager in json format
	 * @return The JSON representation of the score manager
	 */
	public String toJson()
	{
		String json = String.format("{"
				+ "\"type\": \"%s\","
				+ "\"score\": %f"
				+ "}", 
				type, 
				score);
		return json;
	}
	
	
}
