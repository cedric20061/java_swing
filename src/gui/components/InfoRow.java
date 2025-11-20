package gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Représente une ligne d'information : un label et sa valeur.
 */
public class InfoRow extends JPanel {

    private JLabel label;
    private JLabel value;

    /**
     * Constructeur.
     * 
     * @param labelText le texte de l'étiquette (ex : "Marque")
     * @param valueText la valeur associée (ex : "Samsung")
     */
    public InfoRow(String labelText, String valueText) {
        // Utilise un layout horizontal
        setLayout(new BorderLayout(5, 0)); // 5px entre label et value

        // Crée les labels
        label = new JLabel(labelText + " :");
        value = new JLabel(valueText);

        // Style optionnel
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        value.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        // Alignement à gauche
        label.setHorizontalAlignment(SwingConstants.LEFT);
        value.setHorizontalAlignment(SwingConstants.LEFT);

        // Ajout des composants
        add(label, BorderLayout.WEST);
        add(value, BorderLayout.CENTER);

        // Bordure légère pour espacement vertical
        setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
    }

    /**
     * Met à jour la valeur affichée.
     * 
     * @param newValue nouvelle valeur
     */
    public void setValue(String newValue) {
        value.setText(newValue);
    }

    /**
     * Met à jour le label et la valeur
     */
    public void setInfo(String newLabel, String newValue) {
        label.setText(newLabel + " :");
        value.setText(newValue);
    }
}
