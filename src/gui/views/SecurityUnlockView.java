package gui.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Smartphone;

public class SecurityUnlockView extends JPanel {

    private JPasswordField passwordField;
    private JButton submitButton;
    private JLabel statusLabel;

    public SecurityUnlockView(Smartphone smart) {
        // Style général du panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(245, 245, 245));
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Titre
        JLabel title = new JLabel("Pour voir le numéro de téléphone");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Champ mot de passe
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(200, 25));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bouton
        submitButton = new JButton("Afficher le numéro");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String password = getPassword();
            	if("password".equals(password)) {
            		displayPhoneNumber(smart.getPhoneNumber());
            	}else {
            		displayError("Mot de passe incorrect");
            	}
            }
        });

        // Label pour afficher le statut / numéro
        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setForeground(Color.RED);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Espacements
        this.add(title);
        this.add(Box.createVerticalStrut(10));
        this.add(passwordField);
        this.add(Box.createVerticalStrut(10));
        this.add(submitButton);
        this.add(Box.createVerticalStrut(10));
        this.add(statusLabel);
    }

    // Méthode pour afficher le numéro après validation
    public void displayPhoneNumber(String number) {
        statusLabel.setText("Numéro : " + number);
        statusLabel.setForeground(new Color(0, 128, 0)); // vert pour succès
    }

    // Méthode pour afficher un message d'erreur
    public void displayError(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(Color.RED);
    }

    // Récupérer le mot de passe entré
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Permet de relier un ActionListener externe (ex: Controller)
    public void setSubmitAction(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
