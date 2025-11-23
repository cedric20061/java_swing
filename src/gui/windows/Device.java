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

import models.NumericObject;
import models.Smartphone; // utiliser Smartphone ici
import gui.views.DeviceView;
import gui.views.TechSpecsView;
import gui.views.SecurityUnlockView;

public class Device extends Window {

	private NumericObject object; // utiliser Smartphone directement

	public Device(NumericObject object, String title, int width, int height) {
		super(title, width, height);
		this.object = object;

		// Création des vues
		DeviceView generalInfo = new DeviceView(object);
		TechSpecsView techView = new TechSpecsView(object);

		Container container = this.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		try {
		    // Récupère le chemin en fonction du type
		    String imagePath = getImagePathForType(object.getType());

		    BufferedImage img = ImageIO.read(new File(imagePath));
		    ImageIcon icon = new ImageIcon(img);
		    JLabel iconLabel = new JLabel(icon);

		    JPanel iconPanel = new JPanel();
		    iconPanel.add(iconLabel);
		    iconPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

		    container.add(iconPanel);

		} catch (Exception e) {
		    System.err.println("Erreur chargement icône : " + e.getMessage());
		}



		// Panel infos générales + specs
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1, 2, 10, 0));
		infoPanel.add(generalInfo);
		infoPanel.add(techView);

		container.add(infoPanel);

		// Section sécurité uniquement pour smartphone
		if("Smartphone".equals(object.getType())){
			Smartphone smart = (Smartphone) object;
			SecurityUnlockView security = new SecurityUnlockView(smart);
			container.add(security);
		}

		this.setLocationRelativeTo(null);
		super.display();
	}
	
	private String getImagePathForType(String type) {
	    switch (type.toLowerCase()) {
	        case "smartphone":
	            return "./asset/smartphone.jpeg";
	        case "laptop":
	            return "./asset/laptop.jpeg";
	        case "tablet":
	            return "./asset/tablet.jpeg";
	        default:
	            return "./asset/smartphone.jpeg"; 
	    }
	}


}