package gui.views;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import models.NumericObject;
import gui.components.InfoRow;

public class DeviceView extends JPanel {

    private NumericObject object;
    private InfoRow brand;
    private InfoRow model;
    private InfoRow price;
    private InfoRow warrantyYears;
    private InfoRow color;

    public DeviceView(NumericObject object) {
        this.object = object;

        // Titre
        JLabel jName = new JLabel("📌 Infos générales");
        jName.setFont(new Font("SansSerif", Font.BOLD, 14));
        jName.setHorizontalAlignment(JLabel.LEFT);

        // Lignes d'infos
        brand = new InfoRow("Brand", object.getBrand());
        model = new InfoRow("Model", object.getModel());
        price = new InfoRow("Price", String.valueOf(object.getPrice()));
        warrantyYears = new InfoRow("Warranty Years", String.valueOf(object.getWarrantyYears()));
        color = new InfoRow("Color", object.getColor());

        // Layout vertical
        this.setLayout(new GridLayout(6, 1, 5, 5)); // 6 lignes + 5px de spacing
        this.add(jName);
        this.add(brand);
        this.add(model);
        this.add(price);
        this.add(warrantyYears);
        this.add(color);
    }
}
