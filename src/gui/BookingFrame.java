package gui;

import services.FlightService;
import models.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class BookingFrame extends JFrame {
    private JComboBox<String> destinationComboBox;
    private JComboBox<String> timeComboBox;
    private JTextArea flightInfoArea;

    public BookingFrame() {
        setTitle("Flight Booking");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Set background color and font
        getContentPane().setBackground(Color.decode("#f0f8ff"));
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Destination combo box
        JLabel destinationLabel = new JLabel("Select Destination:");
        destinationLabel.setFont(labelFont);
        String[] destinations = {"Cebu", "Davao", "Manila"};
        destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        destinationComboBox.addActionListener((ActionEvent e) -> updateFlightsInfo());

        // Time combo box
        JLabel timeLabel = new JLabel("Select Time:");
        timeLabel.setFont(labelFont);
        timeComboBox = new JComboBox<>();
        timeComboBox.setFont(new Font("Arial", Font.PLAIN, 12));

        // Flight info display
        flightInfoArea = new JTextArea(10, 40);
        flightInfoArea.setEditable(false);
        flightInfoArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(flightInfoArea);

        // Booking button
        JButton bookButton = new JButton("Book Flight");
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        bookButton.setBackground(Color.decode("#4CAF50"));
        bookButton.setForeground(Color.WHITE);
        bookButton.setPreferredSize(new Dimension(150, 40));
        bookButton.addActionListener((ActionEvent e) -> bookFlight());

        // Add components to the frame
        add(destinationLabel);
        add(destinationComboBox);
        add(timeLabel);
        add(timeComboBox);
        add(scrollPane);
        add(bookButton);

        updateFlightsInfo(); // Update flight info on startup

        setVisible(true);
    }

    private void updateFlightsInfo() {
        String selectedDestination = (String) destinationComboBox.getSelectedItem();
        List<Flight> flights = FlightService.loadFlights();

        // Filter flights based on destination
        StringBuilder flightInfo = new StringBuilder();
        timeComboBox.removeAllItems(); // Clear previous times

        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(selectedDestination)) {
                flightInfo.append("Flight Number: ").append(flight.getFlightNumber()).append("\n")
                        .append("Departure: ").append(flight.getDeparture()).append("\n")
                        .append("Price: ₱").append(flight.getPrice()).append("\n")
                        .append("Time: ").append(flight.getTime()).append("\n\n");

                timeComboBox.addItem(flight.getTime()); // Add available times
            }
        }

        flightInfoArea.setText(flightInfo.toString());
    }

    private void bookFlight() {
        String selectedTime = (String) timeComboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Flight booked successfully for time: " + selectedTime);
    }
}
