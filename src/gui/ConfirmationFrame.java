package gui;

import javax.swing.*;
import java.awt.*;

public class ConfirmationFrame extends JFrame {

    public ConfirmationFrame() {
        setTitle("Booking Confirmation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel confirmationLabel = new JLabel("Your booking is confirmed!", SwingConstants.CENTER);
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(confirmationLabel);
        setVisible(true);
    }
}
