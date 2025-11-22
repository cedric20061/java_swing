package models;

import java.util.ArrayList;

/**
 * Represents an employee who can own multiple numerical devices.
 * Supports any object extending NumericObject (Smartphone, Laptop, Tablet, etc.)

 *
 * @author C
 * @version 2.0
 */
public class Employee {

    private String firstName;
    private String lastName;
    private int hireYear;

    // Generic list of numeric devices
    private ArrayList<NumericObject> devices = new ArrayList<>();

    /**
     * Constructor of the Employee class.
     *
     * @param firstName employee first name
     * @param lastName  employee last name
     * @param hireYear  year the employee was hired
     */
    public Employee(String firstName, String lastName, int hireYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireYear = hireYear;
    }

    // --- Getters ---

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getHireYear() {
        return this.hireYear;
    }
    
    public ArrayList<NumericObject> getDevices(){
    	return this.devices;
    }

    // --- Setters ---

    public void setLastName(String newName) {
        this.lastName = newName;
    }

    public void setFirstName(String newName) {
        this.firstName = newName;
    }

    public void setHireYear(int newHireYear) {
        if (newHireYear > 1900)
            this.hireYear = newHireYear;
    }

    // --- Device management ---

    /**
     * Adds any kind of numeric object to the employee.
     *
     * @param device device to add (Smartphone, Laptop, Tablet...)
     */
    public void addNumericObject(NumericObject device) {
        if (device != null)
            this.devices.add(device);
    }

    /**
     * Counts devices of a given brand.
     *
     * @param brand brand to search
     * @return number of devices matching the brand
     */
    public int countDevicesByBrand(String brand) {
        int count = 0;
        for (NumericObject d : devices) {
            if (brand.equalsIgnoreCase(d.getBrand())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the employee's seniority.
     *
     * @param currentYear current year
     * @return number of years worked
     */
    public int calculateSeniority(int currentYear) {
        return currentYear - this.hireYear;
    }

    /**
     * Displays employee information and all assigned devices.
     */
    public void display() {
        System.out.println("=========================================");
        System.out.println("	EMPLOYEE INFORMATION");
        System.out.println("=========================================");
        System.out.println("Name        : " + this.firstName + " " + this.lastName);
        System.out.println("Hire Year   : " + this.hireYear);
        System.out.println("Seniority   : " + calculateSeniority(2025) + " years");
        System.out.println("-----------------------------------------");

        if (devices.isEmpty()) {
            System.out.println("No electronic devices assigned.");
        } else {
            System.out.println("Assigned Devices:");
            int index = 1;
            for (NumericObject device : devices) {
                System.out.println("  • Device #" + index);
                device.display();
                System.out.println();
                index++;
            }
        }

        System.out.println("=========================================\n");
    }
}
