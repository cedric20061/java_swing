package models;

import java.util.ArrayList;

/**
 * Represents a laptop computer extending the NumericObject class.
 * Includes a list of available operating systems and technical specifications
 * such as storage, RAM, CPU, and GPU.
 * 
 * @author Cédric
 * @version 2.0
 */
public class Laptop extends NumericObject {

    private ArrayList<String> OSList = new ArrayList<>();

    // New technical attributes
    private String cpu;
    private String gpu;

    /**
     * Constructor of Laptop class.
     * 
     * @param brand     	laptop brand
     * @param model     	laptop model
     * @param price     	laptop price
     * @param warrantyYears warranty years of the Laptop
	 * @param color  		color of the Laptop
     * @param firstOS   	initial OS installed
     * @param storage   	storage capacity in GB
     * @param ram      		RAM in GB
     * @param cpu       	laptop processor model
     * @param gpu       	laptop graphics processor model
     */
    public Laptop(String brand, String model, double price, int warrantyYears, String color, String type, String firstOS,
                  int storage, int ram, String cpu, String gpu) {

    	super(brand, model, price, warrantyYears, color, type, storage, ram);
        OSList.add(firstOS);
        this.cpu = cpu;
        this.gpu = gpu;
    }

    // --- Getters ---

    public ArrayList<String> getOSList() {
        return OSList;
    }

    public String getCpu() {
        return this.cpu;
    }

    public String getGpu() {
        return this.gpu;
    }

    /**
     * Adds an operating system to the supported list.
     * 
     * @param OSName name of the operating system
     */
    public void addOS(String OSName) {
        if (OSName != null && !OSName.isEmpty() && !OSList.contains(OSName)) {
            OSList.add(OSName);
        }
    }

    /**
     * A laptop is considered high-end if its price is above 1500€ or
     * if it has powerful specs (RAM + CPU + GPU).
     */
    @Override
    public boolean isHighEnd() {
        return price > 1500 || ram >= 16 || gpu.toLowerCase().contains("rtx");
    }

    /**
     * Displays all laptop information in a structured format.
     */
    @Override
    public void display() {
        System.out.println("--------------- LAPTOP ----------------");
        super.display();
        System.out.println("CPU            : " + this.cpu);
        System.out.println("GPU            : " + this.gpu);

        System.out.print("OS List        : ");
        if (OSList.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < OSList.size(); i++) {
                System.out.print(OSList.get(i));
                if (i < OSList.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
    }
}
