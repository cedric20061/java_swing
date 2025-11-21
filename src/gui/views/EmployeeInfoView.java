package gui.views;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.components.InfoRow;
import models.Employee;

public class EmployeeInfoView extends JPanel {
	private InfoRow firstName;
	private InfoRow lastName;
	private InfoRow hireYear;
	private InfoRow seniority;
	
	public EmployeeInfoView(Employee emp) {
		// Titre
        JLabel jName = new JLabel("📌 Infos générales");
        jName.setFont(new Font("SansSerif", Font.BOLD, 14));
        jName.setHorizontalAlignment(JLabel.LEFT);
        
		firstName = new InfoRow("First name", emp.getFirstName());
		lastName = new InfoRow("Last name", emp.getLastName());
		hireYear = new InfoRow("Hire year", String.valueOf(emp.getHireYear()));
		seniority = new InfoRow("Seniority", String.valueOf(emp.calculateSeniority(2025)));
		this.setLayout(new GridLayout(5, 1, 5, 5)); // 6 lignes + 5px de spacing
		this.add(jName);
		this.add(firstName);
		this.add(lastName);
		this.add(hireYear);
		this.add(seniority);
	}
}
