package gui.windows;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.Employee;
import models.NumericObject;
import models.Smartphone;
import gui.views.EmpDeviceList;
import gui.views.EmployeeInfoView;

public class EmployeeGui extends Window {

	public EmployeeGui(Employee emp, String title, int width, int height) {
		super(title, width, height);

		// Création des vues
		EmployeeInfoView generalInfo = new EmployeeInfoView(emp);
		EmpDeviceList deviceList = new EmpDeviceList(emp);

		// Conteneur principal
		Container container = this.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		try {
			BufferedImage img = ImageIO.read(new File("./asset/user.jpeg"));
			ImageIcon icon = new ImageIcon(img);
			JLabel iconLabel = new JLabel(icon);

			// Forcer la taille visible
			//iconLabel.setPreferredSize(new Dimension(150, 150));

			JPanel iconPanel = new JPanel();
			iconPanel.add(iconLabel);

			// Important pour BoxLayout
			iconPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

			container.add(iconPanel);

		} catch (Exception e) {
			System.err.println("Erreur chargement icône : " + e.getMessage());
		}
		container.add(generalInfo);
		container.add(deviceList);

		
		this.setLocationRelativeTo(null); // centré à l'écran
		super.display();

	}
}