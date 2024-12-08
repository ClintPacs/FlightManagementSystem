package services;

import models.Flight;

import java.io.*;
import java.util.*;

public class FlightService {

    private static final String FILE_PATH = "resources/flights.csv";

    public static List<Flight> loadFlights() {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String flightNumber = data[0];
                String departure = data[1];
                String destination = data[2];
                double price = Double.parseDouble(data[3]);
                String time = data[4];
                flights.add(new Flight(flightNumber, departure, destination, price, time));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
