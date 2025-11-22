package models;

/**
 * Represents a generic numerical device with common technical attributes.
 * 
 * @author Cédric GUIDI
 * @version 2.0
 */
public class NumericObject {

	protected String brand;
	protected String model;
	protected double price;
	protected String type;
	// New attributes
	protected int warrantyYears;
	protected double weight;
	protected String color;
	protected int storage;
	protected int ram;

	/**
	 * Base constructor for a numeric device.
	 * 
	 * @param brand         brand of the product
	 * @param model         model of the product
	 * @param price         price in euros
	 * @param warrantyYears warranty years of the product
	 * @param color  		color of the product
	 * @param storage       storage capacity in GB
	 * @param ram           RAM in GB
	 */
	public NumericObject(String brand, String model, double price, 
			int warrantyYears, String color, String type, int storage, int ram) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.warrantyYears = warrantyYears;
		this.color = color;
		this.type = type;
		this.storage = storage;
		this.ram = ram;
	}

	/**
	 * Brand getter
	 * @return The brand
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Model getter
	 * @return The model
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Price getter
	 * @return The price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Warranty years getter
	 * @return The Warranty years
	 */
	public int getWarrantyYears() {
		return this.warrantyYears;
	}

	/**
	 * Weight getter
	 * @return The weight
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Color getter
	 * @return The color
	 */
	public String getColor() {
		return this.color;
	}
	
	public String getType() {
		return this.type;
	}

	public int getStorage() {
		return this.storage;
	}

	public int getRam() {
		return this.ram;
	}

	/**
	 * Brand setter
	 * @param brand The new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Model setter
	 * @param model The new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Price setter
	 * @param price The new price
	 */
	public void setPrice(double price) {
		if (price >= 0)
			this.price = price;
	}

	/**
	 * Indicates if this numeric device is considered high-end.
	 * 
	 * @return true if the price is above 800€, false otherwise
	 */
	public boolean isHighEnd() {
		return (this.price > 800);
	}

	/**
	 * Nicely formatted display of the object.
	 */
	public void display() {
		System.out.println("-----------------------------------------");
		System.out.println("Brand          : " + this.brand);
		System.out.println("Model          : " + this.model);
		System.out.println("Color          : " + this.color);
		System.out.println("Price          : " + this.price + " €");
		System.out.println("Weight         : " + this.weight + " kg");
		System.out.println("Storage        : " + this.storage + " GB");
		System.out.println("RAM            : " + this.ram + " GB");
		System.out.println("Warranty       : " + this.warrantyYears + " years");
		System.out.println("High-End ?     : " + (isHighEnd() ? "YES" : "NO"));
		System.out.println("-----------------------------------------");
	}
}
