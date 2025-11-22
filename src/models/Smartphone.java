package models;

/**
 * Represents a smart phone device extending the generic NumericObject class.
 * 
 * @author Cédric
 * @version 2.0
 */
public class Smartphone extends NumericObject {

	private String phoneNumber;

	/**
	 * Constructor of Smartphone class.
	 * 
	 * @param brand         smartphone brand
	 * @param model         smartphone model
	 * @param price         price of the smartphone
	 * @param phoneNumber   associated phone number
	 * @param warrantyYears warranty years of the smartphone
	 * @param color  		color of the smartphone
	 * @param storage       storage capacity in GB
	 * @param ram           RAM in GB
	 */
	public Smartphone(String brand, String model, double price, String phoneNumber,
			int warrantyYears, String color, String type, int storage, int ram) {
		super(brand, model, price, warrantyYears, color, type, storage, ram);
		this.phoneNumber = phoneNumber;
	}

	// --- Getters ---
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	// --- Setters ---
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	/**
	 * Displays smartphone information in a clean formatted style.
	 */
	@Override
	public void display() {
		System.out.println("-------------- SMARTPHONE --------------");
		super.display();
		System.out.println("Phone Number   : " + this.phoneNumber);
		System.out.println("----------------------------------------");
	}
}
