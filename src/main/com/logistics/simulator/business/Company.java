/**
 * Logistics server side
 */
package com.logistics.simulator.business;

/**
 * A company is a economic entity that own ship
 * @author yifansun
 *
 */
public class Company {
	
	/**
	 * The amount of money that the company has
	 */
	private double money = 0;
	
	/**
	 * The name of the company
	 */
	private String name;
	
	/**
	 * The industry the the company is in
	 */
	private IndustryType industry;

	/**
	 * @param name Name of the company
	 * @param industry The industry that the company is in
	 */
	public Company(String name, IndustryType industry) {
		super();
		this.name = name;
		this.industry = industry;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the industry
	 */
	public IndustryType getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(IndustryType industry) {
		this.industry = industry;
	}

	/**
	 * Represent the object with JSON
	 * @return
	 */
	public String toJson() {
		String json = String.format("{"
				+ "\"industry\": \"%s\", "
				+ "\"name\": \"%s\", "
				+ "\"money\": %f"
				+ "}",
				industry.name(), 
				name,
				money
				);
		return json;
	}

	/**
	 * Add an amount of money to the company, can be both positive or negative
	 * @param profit The profit to win. If loses money, it is negative
	 */
	public void winProfit(double profit) {
		this.money = profit;
	}

}
