package gui.views;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import models.NumericObject;
import gui.components.InfoRow;

public class TechSpecsView extends JPanel {

    private NumericObject object;
    private InfoRow ram;
    private InfoRow storage;

    public TechSpecsView(NumericObject object) {
        this.object = object;

        // Titre
        JLabel jName = new JLabel("⚙️ Caractéristiques");
        jName.setFont(new Font("SansSerif", Font.BOLD, 14));
        jName.setHorizontalAlignment(JLabel.LEFT);

        // Lignes techniques
        ram = new InfoRow("RAM", object.getRam() + " GB");
        storage = new InfoRow("Storage", object.getStorage() + " GB");

        // Layout vertical
        this.setLayout(new GridLayout(3, 1, 5, 5)); // 3 lignes : titre + 2 champs
        this.add(jName);
        this.add(storage);
        this.add(ram);
    }
}
