package com.example.consumer.model;

public class Flight {

    private String origin;
    private String destination;
    private String cost;
    private String when;

    public Flight() {
    }

    public Flight(String origin, String destination, String cost, String when) {
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.when = when;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getCost() {
        return cost;
    }

    public String getWhen() {
        return when;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cost='" + cost + '\'' +
                ", when='" + when + '\'' +
                '}';
    }
}
