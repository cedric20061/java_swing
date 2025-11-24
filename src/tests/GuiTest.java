package tests;

import gui.windows.EmployeeGui;
import models.Employee;
import models.Laptop;
import models.Smartphone;
import models.Tablet;

public class GuiTest {
	public static void main(String[] args) {

		Employee emp = new Employee("Cédric", "GUIDI", 2020);

		Smartphone s1 = new Smartphone(
				"Apple", "iPhone 15", 1299,
				"06 11 22 33 44",
				2,
				"Red",
				"Smartphone",
				256,
				8
				);

		Smartphone s2 = new Smartphone(
				"Samsung", "S24 Ultra", 1400,
				"06 55 66 77 88",
				4,
				"Chrome",
				"Smartphone",
				512,
				12
				);

		Laptop laptop = new Laptop(
				"MSI", "Stealth 16", 2300,2,
				"Siver",
				"Laptop",
				"Windows 11",
				2000,
				32,
				"Intel i9 13700H",
				"RTX 4070"
				);
		laptop.addOS("Ubuntu 22.04");

		Tablet tab = new Tablet(
				"Samsung", "Galaxy Tab S9", 999,2,
				"Graphite",
				"Tablet",
				25.0, 17.8,
				256, 8
				);

		emp.addNumericObject(s1);
		emp.addNumericObject(s2);
		emp.addNumericObject(laptop);
		emp.addNumericObject(tab);

		new EmployeeGui(emp, "Device", 500, 600);
	}
}
