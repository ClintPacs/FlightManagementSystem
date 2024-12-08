package models;

public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private double price;
    private String time;

    public Flight(String flightNumber, String departure, String destination, double price, String time) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }
}
