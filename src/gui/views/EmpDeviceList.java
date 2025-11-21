package gui.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import gui.windows.Device;
import models.Employee;
import models.NumericObject;

public class EmpDeviceList extends JPanel {

	public EmpDeviceList(Employee emp) {

		// Utilisation d'un BoxLayout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		int count = 1;
		for (NumericObject object : emp.getDevices()) {
			JButton but = new JButton("Device " + count + " - " + object.getType());
			but.setAlignmentX(Component.CENTER_ALIGNMENT);
			but.setMaximumSize(new Dimension(200, 30));

			// Ajout de l'ActionListener pour ouvrir la fenêtre Device
			but.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Device(object, "Device", 500, 700);
				}
			});

			// Ajout du bouton au panel
			this.add(but);

			// Espacement vertical
			this.add(Box.createVerticalStrut(5));

			count++;
		}
	}

}
